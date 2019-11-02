class Producto {
    constructor(nombre, precio, año) {
        this.nombre = nombre;
        this.precio = precio;
        this.año = año;
    }
}

class UI {
    agregarProducto(product) {
        const ListaProductos = document.getElementById('product-list');
        const element = document.createElement('div');
        element.innerHTML = `
            <div class="card text-center mb-4">
                <div class="card-body">
                    <strong>Producto</strong>: ${product.nombre} -
                    <strong>Precio</strong>: $${product.precio} - 
                    <strong>año</strong>: ${product.año}
                    <a href="#" class="btn btn-danger" name="delete">Eliminar</a>
                </div>
            </div>
        `;
        ListaProductos.appendChild(element);
    }

    restablecerFormulario() {
        document.getElementById('product-form').reset();
    }

    eliminarProducto(element) {
        if (element.name === 'delete') {
            element.parentElement.parentElement.remove();
            this.mostrarMensage('Producto eliminado', 'success');
        }
    }

    mostrarMensage(message, cssClass) {
        const div = document.createElement('div');
        div.className = `alert alert-${cssClass} mt-2`;
        div.appendChild(document.createTextNode(message));
        const container = document.querySelector('.container');
        const app = document.querySelector('#App');
        container.insertBefore(div, app);
        setTimeout(function () {
            document.querySelector('.alert').remove();
        }, 3000);
    }
}


document.getElementById('product-form')
    .addEventListener('submit', function (e) {

        const nombre = document.getElementById('nombre').value,
            precio = document.getElementById('precio').value,
            año = document.getElementById('año').value;

        const product = new Producto(nombre, precio, año);

        const ui = new UI();

        if (nombre === '' || precio === '' || año === '') {
            ui.mostrarMensage('inserte datos en todos los campos', 'danger');
        }

        ui.agregarProducto(product);
        ui.mostrarMensage('Producto añadido con éxito', 'success');
        ui.restablecerFormulario();
        e.preventDefault();
    });

/*document.getElementById('product-list')
    .addEventListener('click', function (e) {
        const ui = new UI();
        ui.eliminarProducto(e.target);
        e.preventDefault();
});*/
