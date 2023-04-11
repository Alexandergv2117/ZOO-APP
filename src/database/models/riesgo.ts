import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface RiesgoAttributes {
  id: number;
  nivel: string;
}

class Riesgo extends Model<RiesgoAttributes> implements RiesgoAttributes {
  public id!: number;
  public nivel!: string;
}

Riesgo.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    nivel: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Riesgo',
    tableName: 'riesgo',
  }
);

Riesgo.hasMany(Animal, {
  foreignKey: 'riesgo_id',
  sourceKey: 'id',
});

Animal.belongsTo(Riesgo, {
  foreignKey: 'riesgo_id',
  targetKey: 'id',
});

export default Riesgo;
