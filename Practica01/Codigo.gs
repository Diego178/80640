// regresa de forma textual los parámetros leidos con get
  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nom = 'Arnold', ape = 'GetSchwarzenegger' ,tel,dir} = parameter;
    const salida = `Hola ${nom} ${ape} ${tel} ${dir}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los parámetros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nom = 'Arnold', ape = 'PostSchwarzenegger',tel,dir} = parameter;
    const salida = `Hola ${nom} ${ape} ${tel} ${dir}`;
    return ContentService.createTextOutput(salida);
  };
