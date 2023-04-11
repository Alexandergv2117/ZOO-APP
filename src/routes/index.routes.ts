import type { Application } from 'express-serve-static-core';
import authRouter from './auth.routes';
import animalRouter from './animal.routes';
import especieRouter from './especie.routes';

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
const routerAPI = (app: Application) => {
  app.use('/auth', authRouter);
  app.use('/animal', animalRouter);
  app.use('/especie', especieRouter);
};

export default routerAPI;
