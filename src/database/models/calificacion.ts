import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';

interface CalAttributes {
  id: number;
  calificacion: number;
}

class Calificacion extends Model<CalAttributes> implements CalAttributes {
  public id!: number;
  public calificacion!: number;
}

Calificacion.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    calificacion: {
      type: DataTypes.INTEGER,
      allowNull: false,
      defaultValue: '0',
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Calificacion',
    tableName: 'calificacion',
  }
);

export default Calificacion;
