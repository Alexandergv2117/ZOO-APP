import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface fotoAttributes {
  id: number;
  link: string;
}

class Imagen extends Model<fotoAttributes> implements fotoAttributes {
  public id!: number;
  public link!: string;
}

Imagen.init(
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
    modelName: 'Imagen',
    tableName: 'imagen',
  }
);

Animal.hasMany(Imagen, {
  foreignKey: 'animal_id',
  sourceKey: 'id',
});

Imagen.belongsTo(Animal, {
  foreignKey: 'animal_id',
  targetKey: 'id',
});

export default Imagen;
