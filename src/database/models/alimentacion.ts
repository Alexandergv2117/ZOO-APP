import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface AlimentacionAttributes {
  id: number;
  alimentacion: string;
}

class Alimentacion
  extends Model<AlimentacionAttributes>
  implements AlimentacionAttributes
{
  public id!: number;
  public alimentacion!: string;
}

Alimentacion.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    alimentacion: {
      type: DataTypes.STRING,
      allowNull: false,
      defaultValue: '0',
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Alimentacion',
    tableName: 'alimentacion',
  }
);

Alimentacion.hasMany(Animal, {
  foreignKey: 'alimentacion_id',
  sourceKey: 'id',
});

Animal.belongsTo(Alimentacion, {
  foreignKey: 'alimentacion_id',
  targetKey: 'id',
});

export default Alimentacion;
