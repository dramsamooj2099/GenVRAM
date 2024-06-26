/*
 * Copyright (c) 2020 Fraunhofer FOKUS and others. All rights reserved.
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contact: mosaic@fokus.fraunhofer.de
 */

package org.eclipse.mosaic.app.tutorial.message;

import org.eclipse.mosaic.lib.geo.GeoPoint;
import org.eclipse.mosaic.lib.objects.v2x.EncodedPayload;
import org.eclipse.mosaic.lib.objects.v2x.MessageRouting;
import org.eclipse.mosaic.lib.objects.v2x.V2xMessage;

import javax.annotation.Nonnull;

/**
 * Class used as message for inter vehicle communication in contrast
 * to the intra vehicle communication.
 */
public final class InterVehicleMsg extends V2xMessage {
    
    /**
     * Example payload. The sender puts its geo location
     * inside the message and sends it to every possible receiver.
     */
    private final GeoPoint senderPosition;
    private final EncodedPayload payload;
    private final String string_msg;
    private final int msgID;
    private final int seqNum;
    private final static long minLen = 128L;

    public InterVehicleMsg(MessageRouting routing, int msgID, int seqNum, GeoPoint senderPosition, String string_msg) {
        super(routing);
        payload = new EncodedPayload(16L, minLen);
        this.msgID = msgID;
        this.seqNum = seqNum;
        this.string_msg = string_msg;
        this.senderPosition = senderPosition;
    }

    public GeoPoint getSenderPosition() {
        return senderPosition;
    }

    public String getStringMsg() {
        return string_msg;
    }

    @Nonnull
    @Override
    public EncodedPayload getPayLoad() {
        return payload;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InterVehicleMsg{,");
        sb.append("").append(msgID);
        sb.append(", ");
        sb.append("").append(seqNum);
        sb.append(", ");
        sb.append(" ").append(senderPosition.getLatitude());
        sb.append(",  ");
        sb.append(senderPosition.getLongitude());
        sb.append(", ");
        sb.append(string_msg);
        sb.append(", }");
        return sb.toString();
    }
}