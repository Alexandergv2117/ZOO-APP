import express from 'express';
import especieModel from 'src/models/especie.model';

const especieRouter = express.Router();

// eslint-disable-next-line @typescript-eslint/no-misused-promises
especieRouter.get('/', async (_req, res) => {
  const data = await especieModel.getAll();
  res.send(data);
});

export default especieRouter;
