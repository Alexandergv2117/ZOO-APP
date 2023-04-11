import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Comment from './comentario';

interface UserAttributes {
  id: number;
  nombre: string;
  apellidos?: string;
  email: string;
  password: string;
}

class User extends Model<UserAttributes> implements UserAttributes {
  public id!: number;
  public nombre!: string;
  public apellidos?: string;
  public email!: string;
  public password!: string;
}

User.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    nombre: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    apellidos: {
      type: DataTypes.STRING,
    },
    email: {
      type: DataTypes.CHAR,
      allowNull: false,
    },
    password: {
      type: DataTypes.CHAR,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: true,
    modelName: 'User',
    tableName: 'user',
  }
);

User.hasMany(Comment, {
  foreignKey: 'user_id',
  sourceKey: 'id',
});

Comment.belongsTo(User, {
  foreignKey: 'user_id',
  targetKey: 'id',
});

export default User;
