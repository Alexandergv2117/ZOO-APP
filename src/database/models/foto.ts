import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface fotoAttributes {
  id: number;
  link: string;
}

class Foto extends Model<fotoAttributes> implements fotoAttributes {
  public id!: number;
  public link!: string;
}

Foto.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    link: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Foto',
    tableName: 'foto',
  }
);

Animal.hasMany(Foto, {
  foreignKey: 'animal_id',
  sourceKey: 'id',
});

Foto.belongsTo(Animal, {
  foreignKey: 'animal_id',
  targetKey: 'id',
});

export default Foto;
