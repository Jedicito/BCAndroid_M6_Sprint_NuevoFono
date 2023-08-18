package chl.ancud.m6_sprint_nuevofono.data

import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoDetalleEntity
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoListadoEntity
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoDetalle
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado

fun TelefonoListado.transformar(): TelefonoListadoEntity =
    TelefonoListadoEntity(this.id, this.name, this.price, this.image )


fun TelefonoDetalle.transformar(): TelefonoDetalleEntity =
    TelefonoDetalleEntity(this.id, this.name, this.price, this.image, this.description, this.lastPrice, this.credit)