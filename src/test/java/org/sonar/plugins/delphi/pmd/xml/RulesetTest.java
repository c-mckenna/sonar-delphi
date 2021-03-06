/*
 * Sonar Delphi Plugin
 * Copyright (C) 2011 Sabre Airline Solutions
 * Author(s):
 * Przemyslaw Kociolek (przemyslaw.kociolek@sabre.com)
 * Michal Wojcik (michal.wojcik@sabre.com)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.delphi.pmd.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RulesetTest {

  private Ruleset ruleset;

  @Before
  public void init() {
    ruleset = new Ruleset("desc");
  }

  @Test
  public void rulesetTest() {
    assertFalse((new Ruleset().getDescription()) == ruleset.getDescription());
  }

  @Test
  public void descriptionTest() {
    assertEquals("desc", ruleset.getDescription());
    ruleset.setDescription("desc2");
    assertEquals("desc2", ruleset.getDescription());
  }

  @Test
  public void rulesTest() {
    assertEquals(0, ruleset.getRules().size());

    List<DelphiRule> rules = new ArrayList<DelphiRule>();
    rules.add(new DelphiRule("testRule"));
    ruleset.setRules(rules);

    assertEquals(rules, ruleset.getRules());
    assertEquals(1, ruleset.getRules().size());

    ruleset.addRule(new DelphiRule("testRule2"));
    assertEquals(2, ruleset.getRules().size());
  }

}
