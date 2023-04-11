import { Model, DataTypes } from 'sequelize';
import sequelize from '../index';
import Animal from './animal';

interface RiesgoAttributes {
  id: number;
  tipo: string;
  link_foto: string;
}

class Especie extends Model<RiesgoAttributes> implements RiesgoAttributes {
  public id!: number;
  public tipo!: string;
  public link_foto!: string;
}

Especie.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    tipo: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    link_foto: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  },
  {
    sequelize,
    timestamps: false,
    modelName: 'Especie',
    tableName: 'especie',
  }
);

Especie.hasMany(Animal, {
  foreignKey: 'especie_id',
  sourceKey: 'id',
});

Animal.belongsTo(Especie, {
  foreignKey: 'especie_id',
  targetKey: 'id',
});

export default Especie;
