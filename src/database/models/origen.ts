import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface OrigenAttributes {
  id: number;
  origen: string;
}

class Origen extends Model<OrigenAttributes> implements OrigenAttributes {
  public id!: number;
  public origen!: string;
}

Origen.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    origen: {
      type: DataTypes.STRING,
      allowNull: false,
      defaultValue: '0',
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Origen',
    tableName: 'origen',
  }
);

Origen.hasMany(Animal, {
  foreignKey: 'origen_id',
  sourceKey: 'id',
});

Animal.belongsTo(Origen, {
  foreignKey: 'origen_id',
  targetKey: 'id',
});

export default Origen;
