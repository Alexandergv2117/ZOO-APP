import express from 'express';

const authRouter = express.Router();

authRouter
  .get('/', (_req, res) => {
    res.send('Feching for authenticate user');
  })
  .post('/', (_req, res) => {
    res.send('Register user');
  });

export default authRouter;
