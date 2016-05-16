package com.bpena.base;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * BaseUI
 * Esta es la clase de donde extenderán las vistas del proyecto.
 * Contiene funcionalidades básicas de comportamiento y de acciones para la mayoria de las clases hijas,
 * pero si necesita alguna funcionalidad adicional, puede sobre escribir el método en la clase hija.
 * Creado por bpena el 14/5/2016.
 */
public abstract class BaseUI extends VerticalLayout implements View {

    /**
     * La clase donde está contenida esta vista.
     */
    protected BaseContainerUI parentContainer;

    /**
     * Método de validación
     * @return valor dela validación
     */
    protected boolean validate() {
        return true;
    }

    /**
     * Se ejecuta antes de guardar.
     * @return el resultado de la ejecución
     */
    protected boolean preSave() {
        return true;
    }

    /**
     * Se ejecuta luego de guardar.
     * @return el resultado de la ejecución
     */
    protected boolean postSave() {
        setReadOnly(true);
        parentContainer.goToView(BaseContainerUI.actionMenu.LIST);
        return true;
    }

    /**
     * Método para guardar una entidad.
     * Combina llamadas a los métodos validate(), preSave() y postSave()
     * @return el resultado de la ejecución
     */
    protected boolean onSave() {
        if (!preSave())
            return false;

        if (validate()) {

        }

        return postSave();
    }

    /**
     * Se ejecuta antes de cancelar.
     * @return el resultado de la ejecución
     */
    protected boolean preCancel() {
        return true;
    }

    /**
     * Se ejecuta luego de cancelar
     * @return el resultado de la ejecución
     */
    protected boolean postCancel() {
        setReadOnly(true);
        parentContainer.goToView(BaseContainerUI.actionMenu.LIST);
        return true;
    }

    /**
     * Este médoto cancela la edición de un registro, sea nuevo o no.
     * Combina llamadas a los métodos preCancel() y postCancel().
     * @return el resultado de la ejecución
     */
    protected boolean onCancel() {
        if (!preCancel())
            return false;

        return postCancel();
    }

    /**
     * Se ejecuta antes de mostrar la vista para agregar un nuevo registro
     * @return el resultado de la ejecución
     */
    protected boolean preNew() {
        setReadOnly(false);
        return true;
    }

    /**
     * Se ejecuta luego de mostrar la vista para agregar un nuevo registro
     * @return el resultado de la ejecución
     */
    protected boolean postNew() {
        return true;
    }

    /**
     * Muestra una vista para agregar un nuevo registro
     * @return el resultado de la ejecución
     */
    protected boolean onNew() {
        if (!preNew())
            return false;

        return postNew();
    }

    /**
     * Se ejecuta antes de mostrar la vista para editar un registro
     * @return el resultado de la ejecución
     */
    protected boolean preEdit() {
        setReadOnly(false);
        return true;
    }

    /**
     * Se ejecuta luego de mostrar la vista para editar un registro
     * @return el resultado de la ejecución
     */
    protected boolean postEdit() {
        return true;
    }

    /**
     * Muestra la vista para editar un registro.
     * @return el resultado de la ejecución.
     */
    protected boolean onEdit() {
        if (!preEdit())
            return false;

        return postEdit();
    }

    /**
     * Se ejecuta antes de eliminar un registro.
     * @return el resultado de la ejecución
     */
    protected boolean preDelete() {
        return true;
    }

    /**
     * Se ejecuta luego de eliminar un registro.
     * @return el resultado de la ejecución
     */
    protected boolean postDelete() {
        return  true;
    }

    /**
     * Elimina un registro
     * @return
     */
    protected boolean onDelete() {
        if (!preDelete())
            return false;

        return postDelete();
    }

    /**
     * Asigna el contenedor padre de la vista actual.
     * @param parentContainer
     */
    public void setParentContainer(BaseContainerUI parentContainer) {
        this.parentContainer = parentContainer;
    }

    /**
     * Retorna el contenedor padre de la vista actual
     * @return el contenedor padre
     */
    public BaseContainerUI getParentContainer() {
        return this.parentContainer;
    }

    /**
     * Cambia el valor del readOnly de la vista, ajustando además sus componentes.
     * @param readOnly
     */
    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);

        for (Component c : this) {
            c.setReadOnly(readOnly);
        }
    }
}
