import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface HabitatAttributes {
  id: number;
  habitat: string;
}

class Habitat extends Model<HabitatAttributes> implements HabitatAttributes {
  public id!: number;
  public habitat!: string;
}

Habitat.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    habitat: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Habitat',
    tableName: 'habitat',
  }
);

Habitat.hasMany(Animal, {
  foreignKey: 'habitat_id',
  sourceKey: 'id',
});

Animal.belongsTo(Habitat, {
  foreignKey: 'habitat_id',
  targetKey: 'id',
});

export default Habitat;
