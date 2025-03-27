const knex = require('./database');
const express = require('express');
const app = express();
const port = 8080;

// Middleware básico para ler JSON
app.use(express.json());

// Rota POST simples para passageiros
app.post('/passageiros', async (req, res) => {
    try {
      // Validação simples
      if (!req.body.nome || !req.body.cpf) {
        return res.status(400).json({ error: 'Nome e CPF são obrigatórios' });
      }
  
      const [id] = await knex('passageiros').insert({
        nome: req.body.nome,
        cpf: req.body.cpf,
        email: req.body.email || null
      });
  
      res.status(201).json({ id, message: 'Passageiro cadastrado com sucesso!' });
    } catch (error) {
      if (error.code === 'ER_DUP_ENTRY') {
        return res.status(400).json({ error: 'CPF já cadastrado' });
      }
      res.status(500).json({ error: 'Erro interno no servidor' });
    }
});

app.get('/passageiros', async (req, res) => {
    try {
      const passageiros = await knex('passageiros')
        .select('id', 'nome', 'email')
        .orderBy('nome', 'asc');
  
      res.json(passageiros);
    } catch (error) {
      res.status(500).json({ error: 'Erro ao buscar passageiros' });
    }
});

app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});