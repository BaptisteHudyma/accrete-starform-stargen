package com.szadowsz.starform.profile.accrete

import com.szadowsz.starform.model.accrete.AccreteProfile
import com.szadowsz.starform.model.accrete.calc.collision.{CollisionCalc, DoleCollCalc}
import com.szadowsz.starform.model.accrete.calc.insert.{AccreteInsertStrat, RandInsertStrat}
import com.szadowsz.starform.model.accrete.calc.planet.{DolePlanCalc, PlanetesimalCalc}
import com.szadowsz.starform.model.accrete.calc.{AccreteCalc, DoleAccCalc}
import com.szadowsz.starform.model.accrete.constants.{AccreteConstants, FKeris2Constants}
import com.szadowsz.starform.rand.{JDKRandGen, RandGenTrait}

/**
  * Created on 11/04/2017.
  */
class FKeris2Profile extends AccreteProfile{

  override val rand: RandGenTrait = new JDKRandGen() // TODO check if this aligns to the c/c++ variant

  override val accConsts: AccreteConstants = new FKeris2Constants()

  // TODO separate profile for earlier folkins code as it does something different
  override def buildInsertStrat(aConst : AccreteConstants): AccreteInsertStrat = new RandInsertStrat(aConst)

  override def buildPlanCalc(aConst : AccreteConstants): PlanetesimalCalc =  DolePlanCalc(aConst)

  override def buildCollCalc(pCalc: PlanetesimalCalc): CollisionCalc = DoleCollCalc(pCalc)

  override def buildAccCalc(pCalc: PlanetesimalCalc, aConst: AccreteConstants): AccreteCalc = DoleAccCalc(pCalc,aConst) // TODO check if it should use fogg calc
}
