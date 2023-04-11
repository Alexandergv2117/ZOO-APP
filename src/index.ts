import express from 'express';
import cors from 'cors';
import routerAPI from '@routes/index.routes';
import * as dotenv from 'dotenv';

dotenv.config();

const PORT = process.env.PORT;

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cors());

routerAPI(app);

app.use((_req, res, next) => {
  res.status(404).send({ message: 'Page not found' });
  next();
});

app.listen(PORT, () => {
  console.log('Server running on port: ', PORT);
});
