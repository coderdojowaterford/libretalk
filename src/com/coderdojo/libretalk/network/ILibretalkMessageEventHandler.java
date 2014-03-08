package com.coderdojo.libretalk.network;

import com.rabbitmq.client.ShutdownSignalException;

/**
 * Handles all events fired by Libretalk Network Components.
 * 
 * @author Liam Power
 * @version 3.3
 *
 */
public interface ILibretalkMessageEventHandler
{
    
    /**
     * Fired when a message is received from {@link LibretalkMessageReceiver}
     * 
     * @param message The message retrieved from the RabbitMQ message queue. This can usually be encoded into a UTF-8 String
     */
    void onMessageReceived(final byte[] message);
    
    /**
     * Fired when the {@link LibretalkConnection} is dropped.
     * 
     * @param signal The {@link ShutdownSignalException} used to store information about the disconnection event.
     */
    void onDisconnect(final Exception ex);
}
