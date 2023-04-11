/* eslint-disable @typescript-eslint/no-floating-promises */
import sequelize from '../index';

// MODELS
import User from '../models/user';
import Comment from '../models/comentario';
import Calificacion from '../models/calificacion';
import Animal from '../models/animal';
import Imagen from '../models/imagen';
import Riesgo from '../models/riesgo';
import TipoReproduccion from '../models/tipo_reproduccion';
import Alimentacion from '../models/alimentacion';
import Especie from '../models/especie';
import Habitat from '../models/habitat';
import Origen from '../models/origen';
import Autor from '../models/autor';

// SEEDERS
import riesgo from './riesgo';
import especie from './especie';
import tipo_reproduccion from './tipo_reproduccion';
import alimentacion from './alimentacion';
import origen from './origen';

(async () => {
  try {
    await sequelize.authenticate();
    await sequelize.sync({ force: true });

    await Calificacion.findAll();
    await User.findAll();
    await Comment.findAll();

    await Riesgo.findAll();
    await TipoReproduccion.findAll();
    await Alimentacion.findAll();
    await Especie.findAll();
    await Animal.findAll();
    await Imagen.findAll();
    await Habitat.findAll();
    await Origen.findAll();
    await Autor.findAll();

    await riesgo.up(sequelize.getQueryInterface());
    await especie.up(sequelize.getQueryInterface());
    await tipo_reproduccion.up(sequelize.getQueryInterface());
    await alimentacion.up(sequelize.getQueryInterface());
    await origen.up(sequelize.getQueryInterface());

    console.log('TABLAS CREADAS');
  } catch (e) {
    console.log({ e });
  }
})();
