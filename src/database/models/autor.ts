import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Imagen from './imagen';

interface AutorAttributes {
  id: number;
  nombre: string;
}

class Autor extends Model<AutorAttributes> implements AutorAttributes {
  public id!: number;
  public nombre!: string;
}

Autor.init(
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
  },
  {
    sequelize,
    timestamps: true,
    modelName: 'Autor',
    tableName: 'autor',
  }
);

Autor.hasMany(Imagen, {
  foreignKey: 'autor_id',
  sourceKey: 'id',
});

Imagen.belongsTo(Autor, {
  foreignKey: 'autor_id',
  targetKey: 'id',
});

export default Autor;
