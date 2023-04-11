import * as dotenv from 'dotenv';

dotenv.config();

const configDB = {
  DB: process.env.DB_NAME as string,
  username: process.env.DB_USER as string,
  password: process.env.DB_PASS as string,
  dialect: 'mysql',
  host: process.env.DB_HOST as string,
  port: process.env.DB_PORT as unknown as number,
};

export default configDB;
