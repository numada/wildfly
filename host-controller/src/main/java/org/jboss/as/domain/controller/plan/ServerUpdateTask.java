/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.domain.controller.plan;

import org.jboss.as.domain.controller.ServerIdentity;
import org.jboss.dmr.ModelNode;

/**
 * Base class for tasks that can perform an update on a server.
 *
 * @author Brian Stansberry
 */
abstract class ServerUpdateTask {

    protected final ServerUpdatePolicy updatePolicy;
    protected final ServerIdentity serverId;

    /**
     * Create a new update task.
     *  @param serverId the id of the server being updated. Cannot be <code>null</code>
     * @param updatePolicy the policy that controls whether the updates should be applied. Cannot be <code>null</code>
     */
    ServerUpdateTask(final ServerIdentity serverId,
                     final ServerUpdatePolicy updatePolicy) {
        assert serverId != null : "serverId is null";
        assert updatePolicy != null : "updatePolicy is null";
        this.serverId = serverId;
        this.updatePolicy = updatePolicy;
    }

    public abstract ModelNode getOperation();

    public ServerIdentity getServerIdentity() {
        return serverId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{server=" + serverId.getServerName() + "}";
    }
}
