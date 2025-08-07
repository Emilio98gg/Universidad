const express = require('express');
const sql = require('mssql');

const app = express();
const port = 3000;

// Configuración de la conexión a SQL Server
const config = {
    user: 'LAPTOP-GJTCRLQ2\SQLEXPRESS',
    password: '',
    server: 'localhost', // Puede variar según tu configuración
    database: 'nIndustria_Global_S_A',
    options: {
        encrypt: true, // para Azure
        trustServerCertificate: true, // para auto-firmado
    },
};

// Conexión a la base de datos
sql.connect(config, (err) => {
    if (err) {
        console.error('Error conectando a la base de datos:', err);
    } else {
        console.log('Conexión exitosa a SQL Server');
    }
});

// Endpoint para obtener proveedores
app.get('/api/proveedores', async (req, res) => {
    try {
        const result = await sql.query('SELECT * FROM Proveedores');
        res.json(result.recordset);
    } catch (err) {
        console.error('Error ejecutando la consulta:', err);
        res.status(500).send('Error al obtener los proveedores');
    }
});

app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:${port}`);
});
