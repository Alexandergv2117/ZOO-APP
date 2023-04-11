import { type QueryInterface } from 'sequelize';

export default {
  up: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkInsert('riesgo', [
      {
        nivel: 'bajo',
      },
      {
        nivel: 'medio',
      },
      {
        nivel: 'alto',
      },
    ]);
  },
  down: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkDelete('riesgo', {}, {});
  },
};
