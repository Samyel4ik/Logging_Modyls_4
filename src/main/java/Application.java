import java.util.logging.Logger;

public class Application {
    private static final Logger log = Logger.getLogger(String.valueOf(Application.class));

    public static void main(String[] args) {
        log.info("Application started");
        ApplicationConfig applicationConfig = new ApplicationConfig("application.properties");
        log.info("read application properties");
        String suffix = applicationConfig.getSuffix();

        for (String nameFile : applicationConfig.getFileNames()) {

            RenamableFile renamableFile = new RenamableFile(nameFile);
            String newNameFile = renamableFile.appendSuffix(suffix);

            log.info(String.format("%s->%s", nameFile, newNameFile));
        }
        log.info("the end of the application");
    }
}
