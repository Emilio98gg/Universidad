function getData() {
    const codCategoria = document.getElementById('codCategoriaInput').value;
    const oferta = document.getElementById('ofertaInput').value;

    fetch(`https://apis.cesoftcr.com/desa/v1/productos.php`)
        .then(response => response.json())
        .then(data => {
            const filteredData = data.filter(item => {
                return item.cod_categoria === codCategoria && item.oferta === oferta;
            });

            const tableContainer = document.getElementById('tableContainer');
            tableContainer.innerHTML = '';
            if (filteredData.length > 0) {
                const table = document.createElement('table');
                table.classList.add('table');
                table.innerHTML = `
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Producto</th>
                            <th>Oferta</th>
                            <th>Mjsoferta</th>
                            <th>Cod_categoria</th>
                            <th>Des_categoria</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${filteredData.map(item => `
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.producto}</td>
                                <td>${item.oferta}</td>
                                <td>${item.mjsoferta}</td>
                                <td>${item.cod_categoria}</td>
                                <td>${item.des_categoria}</td>
                            </tr>
                        `).join('')}
                    </tbody>
                `;
                tableContainer.appendChild(table);
            } else {
                tableContainer.innerHTML = '<p>No se encontraron resultados.</p>';
            }
        })
        .catch(error => console.error('Error:', error));
}

function mostrarTodos() {
    fetch(`https://apis.cesoftcr.com/desa/v1/productos.php`)
        .then(response => response.json())
        .then(data => {
            const tableContainer = document.getElementById('tableContainer');
            tableContainer.innerHTML = '';
            if (data.length > 0) {
                const table = document.createElement('table');
                table.classList.add('table');
                table.innerHTML = `
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Producto</th>
                            <th>Oferta</th>
                            <th>Mjsoferta</th>
                            <th>Cod_categoria</th>
                            <th>Des_categoria</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(item => `
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.producto}</td>
                                <td>${item.oferta}</td>
                                <td>${item.mjsoferta}</td>
                                <td>${item.cod_categoria}</td>
                                <td>${item.des_categoria}</td>
                            </tr>
                        `).join('')}
                    </tbody>
                `;
                tableContainer.appendChild(table);
            } else {
                tableContainer.innerHTML = '<p>No se encontraron resultados.</p>';
            }
        })
        .catch(error => console.error('Error:', error));
}

function limpiarTablas() {
    const tableContainer = document.getElementById('tableContainer');
    tableContainer.innerHTML = '';
}