import { type QueryInterface } from 'sequelize';

export default {
  up: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkInsert('especie', [
      {
        tipo: 'Anfibios',
        link_foto:
          'https://drive.google.com/file/d/1HbhxPug1ft_RRfrXhd6etmP9v1dcNhX-/view?usp=share_link',
      },
      {
        tipo: 'Reptiles',
        link_foto:
          'https://drive.google.com/file/d/1qeTJV2DRk8It3nKOdcyQrCiDEJrNMgkU/view?usp=share_link',
      },
    ]);
  },
  down: async (queryInterface: QueryInterface) => {
    await queryInterface.bulkDelete('especie', {}, {});
  },
};
