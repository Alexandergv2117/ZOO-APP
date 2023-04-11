import Especie from '@models/especie';

export default {
  getAll: async () => {
    try {
      return await Especie.findAll();
    } catch (error) {
      return { error };
    }
  },
};
