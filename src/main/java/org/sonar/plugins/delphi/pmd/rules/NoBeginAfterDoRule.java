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
package org.sonar.plugins.delphi.pmd.rules;

import org.antlr.runtime.tree.Tree;
import org.sonar.plugins.delphi.antlr.analyzer.LexerMetrics;
import org.sonar.plugins.delphi.antlr.ast.DelphiPMDNode;

/**
 * Checks, if we put 'begin' after 'do' statement
 */
public class NoBeginAfterDoRule extends DelphiRule {

  @Override
  public Object visit(DelphiPMDNode node, Object data) {
    if (shouldCheck(node)) {
      Tree nextNode = node.getParent().getChild(node.getChildIndex() + 1);

      if (isWrongNode(nextNode)) {
        addViolation(data, node);
      }

    }

    return data;
  }

  protected boolean isWrongNode(Tree node) {
    return node == null || (node.getType() != LexerMetrics.BEGIN.toMetrics() && node.getType() != LexerMetrics.WITH.toMetrics());
  }

  protected boolean shouldCheck(Tree node) {
    return node != null && node.getType() == LexerMetrics.DO.toMetrics();
  }

}
