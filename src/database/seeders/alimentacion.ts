import { type QueryInterface } from 'sequelize';

export default {
  up: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkInsert('alimentacion', [
      {
        alimentacion: 'Carnívoros ',
      },
      {
        alimentacion: 'Herbívoros  ',
      },
      {
        alimentacion: 'Omnívoros  ',
      },
    ]);
  },
  down: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkDelete('alimentacion', {}, {});
  },
};
