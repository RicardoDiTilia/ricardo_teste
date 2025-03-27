// database.js
const knex = require('knex')({
    client: 'mysql2',
    connection: {
      host: 'localhost',
      user: 'SEU_USUARIO',      // Substitua pelo seu usuário
      password: 'SUA_SENHA',    // Substitua pela sua senha
      database: 'corridas_db'   // Nome do banco que você já criou
    },
    pool: { min: 0, max: 10 }  // Configuração de conexões
  });
  
  // Teste a conexão (opcional)
  knex.raw("SELECT 1")
    .then(() => console.log('✅ Conexão com MySQL estabelecida'))
    .catch(e => console.error('❌ Erro na conexão:', e));
  
  module.exports = knex;