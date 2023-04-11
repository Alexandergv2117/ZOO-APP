import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Calificacion from './calificacion';

interface CommentAttributes {
  id: number;
  content: string;
}

class Comment extends Model<CommentAttributes> implements CommentAttributes {
  public id!: number;
  public content!: string;
}

Comment.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    content: {
      type: DataTypes.TEXT,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: true,
    modelName: 'Comment',
    tableName: 'comment',
  }
);

Calificacion.hasMany(Comment, {
  foreignKey: 'calificacion_id',
  sourceKey: 'id',
});

Comment.belongsTo(Calificacion, {
  foreignKey: 'calificacion_id',
  targetKey: 'id',
});

export default Comment;
