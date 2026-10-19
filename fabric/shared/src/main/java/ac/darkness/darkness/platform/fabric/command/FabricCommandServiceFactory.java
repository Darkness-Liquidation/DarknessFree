package ac.darkness.darkness.platform.fabric.command;

import ac.darkness.darkness.command.CloudCommandService;
import ac.darkness.darkness.platform.api.command.CommandService;
import ac.darkness.darkness.platform.api.manager.cloud.CloudPlatformCommandArguments;
import ac.darkness.darkness.platform.api.sender.Sender;
import org.incendo.cloud.CommandManager;
import org.incendo.cloud.SenderMapper;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.fabric.FabricServerCommandManager;
import org.jetbrains.annotations.NotNull;

public final class FabricCommandServiceFactory {

    private FabricCommandServiceFactory() {
    }

    public static CommandService create(CloudPlatformCommandArguments commandArguments) {
        @SuppressWarnings({"rawtypes", "unchecked"})
        CommandManager<@NotNull Sender> manager = new FabricServerCommandManager(
                ExecutionCoordinator.simpleCoordinator(),
                SenderMapper.identity()
        );
        return new CloudCommandService(() -> manager, commandArguments);
    }
}
