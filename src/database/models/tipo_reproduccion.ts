import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface TipoReproduccionAttributes {
  id: number;
  tipo: string;
}

class TipoReproduccion
  extends Model<TipoReproduccionAttributes>
  implements TipoReproduccionAttributes
{
  public id!: number;
  public tipo!: string;
}

TipoReproduccion.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    tipo: {
      type: DataTypes.STRING,
      allowNull: false,
      defaultValue: '0',
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'TipoReproduccion',
    tableName: 'tipo_reproduccion',
  }
);

TipoReproduccion.hasMany(Animal, {
  foreignKey: 'tipo_reproduccion_id',
  sourceKey: 'id',
});

Animal.belongsTo(TipoReproduccion, {
  foreignKey: 'tipo_reproduccion_id',
  targetKey: 'id',
});

export default TipoReproduccion;
