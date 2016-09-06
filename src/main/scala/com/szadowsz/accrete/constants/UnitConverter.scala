package com.szadowsz.accrete.constants

import com.szadowsz.accrete.constants.units.MassConstants

/**
  * @author Zakski : 03/07/2015.
  */
object UnitConverter extends MassConstants {

  def solarMassToEarthMass(sunMass: Double): Double = sunMass * SOLAR_MASS_IN_EARTH_MASS
}
