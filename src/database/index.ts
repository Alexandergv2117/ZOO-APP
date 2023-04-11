import { Sequelize } from 'sequelize';
import configDB from './config';

const sequelize = new Sequelize(
  configDB.DB,
  configDB.username,
  configDB.password,
  {
    host: configDB.host,
    port: configDB.port,
    dialect: 'mysql',
  }
);

export default sequelize;
