package chl.ancud.m6_sprint_nuevofono.data

import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoDetalle
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun transformar() {
        //given
        val telefonoListado = TelefonoListado(1, "Nokia 6", 121212, "imagen")

        //when
        val resultado = telefonoListado.transformar()

        //then
        assertEquals(telefonoListado.id, resultado.id)
        assertEquals(telefonoListado.name, resultado.name)
        assertEquals(telefonoListado.price, resultado.price)
        assertEquals(telefonoListado.image, resultado.image)
    }

    @Test
    fun detalleTransformar() {
        val telefonoDetalle = TelefonoDetalle(1, "Nokia 6", 121212, "iamgen"
            , "Descripcion de cosas", 1111111, true)

        val resultado = telefonoDetalle.transformar()

        assertEquals(telefonoDetalle.id, resultado.id)
        assertEquals(telefonoDetalle.name, resultado.name)
        assertEquals(telefonoDetalle.price, resultado.price)
        assertEquals(telefonoDetalle.image, resultado.image)
        assertEquals(telefonoDetalle.description, resultado.description)
        assertEquals(telefonoDetalle.lastPrice, resultado.lastPrice)
        assertEquals(telefonoDetalle.credit, resultado.credit)
    }
}