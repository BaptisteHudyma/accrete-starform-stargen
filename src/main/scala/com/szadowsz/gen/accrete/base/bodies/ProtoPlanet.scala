package com.szadowsz.gen.accrete.base.bodies

import java.text.DecimalFormat

import com.szadowsz.gen.accrete.base.calc.{OrbitalCalc, PlanetesimalCalc}
import com.szadowsz.gen.util.unit.UnitConverter

object ProtoPlanet {

  def apply(calc: PlanetesimalCalc, m: Double, a: Double, e: Double): ProtoPlanet = {
    new ProtoPlanet(calc, m, a, e)
  }
}

/**
 * Class to represent an accreting proto planetary body. Uses an internal linked-list structure to maintain the
 * ordering of the protoplanets.
 *
 * @see Planetismal.java - Ian Burrell (accrete)
 * @see struct planets_record, line 4 in structs.h - Mat Burdick (accrete)
 * @see struct planets_record, line 4 in structs.h - Mat Burdick (starform)
 * @see Protoplanet.java - Carl Burke (starform)
 *
 * @constructor Constructor is used make all subsequent dust bands during the splitting process, in which we
 *              acknowledge dust and gas being removed from part of existing bands.
 *
 * @param calc inner limit of the dust band in AU.
 * @param m outer limit of the dust band in AU.
 * @param a true if dust is present, false otherwise.
 * @param e true if gas is present, false otherwise.

 * @author Zakski : 25/06/2015.
 */
class ProtoPlanet(calc: PlanetesimalCalc, m: Double, a: Double, e: Double) extends OrbitalCalc {

  /**
   * The chosen calculation system for the accretion process.
   */
  private val _accrete = calc

  /**
   * The mas of the planetismal body.
   *
   * @note unit of value is Solar Masses.
   */
  var mass: Double = m

  /**
   * The semi-major axis of the body's orbit.
   *
   * @note unit of value is AU.
   */
  var axis: Double = a

  /**
   * The Eccentricity of the body's orbit. How wildly it deviates from the semi-major axis during the course of one
   * revolution around its planetary body.
   *
   * @note value between 0.0 (inclusive) and 1.0 (exclusive), this range is essential for the body to stay
   *       in the system.
   */
  var ecc: Double = e

  /**
   * The closest to the star that the planet will accrete mass from, given gravitational pull.
   *
   * @note unit of value is AU.
   */
  def innerGravLimit: Double = _accrete.innerGravLimit(perihelion, mass)

  /**
   * The furthest from the star that the planet will accrete mass from, given gravitational pull.
   *
   * @note unit of value is AU.
   */
  def outerGravLimit: Double = _accrete.outerGravLimit(aphelion, mass)

  /**
    * The furthest from the star that the planet will be during its orbit..
   *
   * @note unit of value is AU.
   */
  def aphelion: Double = {
    aphelionDistance(axis, ecc)
  }

  /**
    * The closest to the star that the planet will accrete mass from, given gravitational pull and
    * cloud particle eccentricity.
   *
   * @note unit of value is AU.
   */
  def innerBandLimit: Double = _accrete.innerBandLimit(_accrete.innerGravLimit(perihelion, mass))

  /**
   * The furthest from the star that the planet will accrete mass from, given gravitational pull and
   * cloud particle eccentricity.
   *
   * @note unit of value is AU.
   */
  def outerBandLimit: Double = _accrete.outerBandLimit(_accrete.outerGravLimit(aphelion, mass))

  /**
   * Method to supply String representation of the proto planet.
   *
   * @return current status of the  proto planet in String form.
   */
  override def toString: String = {
    var df: DecimalFormat = new DecimalFormat("#.00000")
    val build: StringBuilder = new StringBuilder("[axis: ")
    build.append(df.format(axis) + "AU eccentricity: ")
    build.append(df.format(ecc) + " mass: ")
    df = new DecimalFormat("#.00000E00")
    build.append(df.format(mass))
    if (mass > 2e-15) {
      df = new DecimalFormat("#.00")
      build.append(" (" + df.format(UnitConverter.solarMassToEarthMass(mass) * 100) + "% of Earth Mass)")
    }
    build.append(" gasGiant: " + (if (isGas) "Y" else "N"))
    build.append("]")
    build.toString()
  }

  /**
   * Whether the planet has surpassed its critical mass limit and become a gas giant.
   */
  def isGas: Boolean = mass >= criticalMass

  /**
   * the limit at which a proto planet has gained enough mass to accrete gas as well as dust
   *
   * @note unit of value is Solar Masses.
   */
  def criticalMass: Double = _accrete.criticalMass(perihelion)

  /**
    * The closest to the star that the planet will be during its orbit.
    *
    * @note unit of value is AU.
    */
  def perihelion: Double = {
    perihelionDistance(axis, ecc)
  }
}
