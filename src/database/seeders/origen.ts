import { type QueryInterface } from 'sequelize';

export default {
  up: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkInsert('origen', [
      {
        origen: 'Especie endémica ',
      },
      {
        origen: 'Especie no endémica',
      },
      {
        origen: 'Especie introducida',
      },
      {
        origen: 'Especie invasora',
      },
      {
        origen: 'Especie migratoria',
      },
    ]);
  },
  down: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkDelete('origen', {}, {});
  },
};
