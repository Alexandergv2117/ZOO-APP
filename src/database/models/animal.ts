import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';

interface AnimalAttributes {
  id: number;
  nombre: string;
  scientific_name: string;
  tamanio: string;
  descripcion: string;
  link_video: string;
  link_map: string;
  link_audio: string;
  link_gif: string;
}

class Animal extends Model<AnimalAttributes> implements AnimalAttributes {
  public id!: number;
  public nombre!: string;
  public scientific_name!: string;
  public tamanio!: string;
  public descripcion!: string;
  public link_video!: string;
  public link_map!: string;
  public link_audio!: string;
  public link_gif!: string;
}

Animal.init(
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
    scientific_name: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    tamanio: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    descripcion: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    link_video: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    link_map: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    link_audio: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    link_gif: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: true,
    modelName: 'Animal',
    tableName: 'animal',
  }
);

export default Animal;
