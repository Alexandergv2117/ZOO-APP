import Alimentacion from '@models/alimentacion';
import Animal from '@models/animal';
import Especie from '@models/especie';
import Habitat from '@models/habitat';
import Origen from '@models/origen';
import Riesgo from '@models/riesgo';
import TipoReproduccion from '@models/tipo_reproduccion';
import sequelize from '../database/index';

export default {
  getAll: async (id: number) => {
    try {
      const data = await Animal.findAll({
        attributes: [
          [sequelize.col('nombre'), 'nombre'],
          [sequelize.col('scientific_name'), 'scientific_name'],
          [sequelize.col('Especie.link_foto'), 'imagen'],
          [sequelize.col('tamanio'), 'tamanio'],
          [sequelize.col('descripcion'), 'descripcion'],
          [sequelize.col('Riesgo.nivel'), 'Riesgo'],
          [sequelize.col('TipoReproduccion.tipo'), 'reproduccion'],
          [sequelize.col('Alimentacion.alimentacion'), 'alimentacion'],
          [sequelize.col('Origen.origen'), 'origen'],
          [sequelize.col('Habitat.habitat'), 'Habitat'],
        ],
        include: [
          {
            model: Especie,
            attributes: [],
          },
          {
            model: Riesgo,
            attributes: [],
          },
          {
            model: TipoReproduccion,
            attributes: [],
          },
          {
            model: Alimentacion,
            attributes: [],
          },
          {
            model: Origen,
            attributes: [],
          },
          {
            model: Habitat,
            attributes: [],
          },
        ],
        where: {
          '$Especie.id$': id,
        },
      });
      return data;
    } catch (error) {
      return { error };
    }
  },
};
