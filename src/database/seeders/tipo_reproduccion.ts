import { type QueryInterface } from 'sequelize';

export default {
  up: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkInsert('tipo_reproduccion', [
      {
        tipo: 'ovíparos (ponen huevos)',
      },
      {
        tipo: 'vivíparo (dan a luz crías vivas)',
      },
    ]);
  },
  down: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkDelete('tipo_reproduccion', {}, {});
  },
};
