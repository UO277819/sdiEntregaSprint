package com.uniovi.sdientrega173;

import com.uniovi.sdientrega173.entities.Publication;
import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.pageobjects.*;
import com.uniovi.sdientrega173.repositories.LogsRepository;
import com.uniovi.sdientrega173.repositories.UsersRepository;
import com.uniovi.sdientrega173.services.PublicationsService;
import com.uniovi.sdientrega173.services.RelationshipService;
import com.uniovi.sdientrega173.services.RolesService;
import com.uniovi.sdientrega173.services.UsersService;
import com.uniovi.sdientrega173.util.SeleniumUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.channels.SeekableByteChannel;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SdiEntrega173ApplicationTests {

    @Autowired
    private UsersService usersService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PublicationsService publicationsService;
    @Autowired
    private RelationshipService relationshipService;
    @Autowired
    private LogsRepository logsRepository;


    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    //static String Geckodriver = "C:\\Path\\geckodriver-v0.30.0-win64.exe";
    //static String Geckodriver = "C:\\Dev\\tools\\selenium\\geckodriver-v0.30.0-win64.exe";
    //static String Geckodriver = "C:\\Users\\marco\\Desktop\\WORKSPACE\\SDI\\Practica5\\material\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    //static String Geckodriver = "C:\\Users\\Usuario\\Documents\\CLASE\\CURSO 2021-2022\\SDI\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    //static String PathFirefox = "C:\\Users\\marco\\Desktop\\WORKSPACE\\SDI\\Practica5\\material\\FirefoxPortable\\App\\Firefox64\\firefox.exe";

    //static String Geckodriver = "C:\\Users\\Jorge\\Documents\\Uni Clases\\Uni 3er Curso\\2o Cuatri\\SDI\\Prácticas" +
    //     "\\Lab05\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";
    static String Geckodriver = "C:\\Users\\aaron\\Downloads\\Nueva carpeta (12)\\sesion06\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    // Común a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";

    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeEach
    public void setUp() {
        initdb();
        driver.navigate().to(URL);

    }

    private void initdb() {

        usersRepository.deleteAll();
        logsRepository.deleteAll();

        User user1 = new User("user01@email.com", "Pedro", "Díaz");
        user1.setPassword("user01");
        user1.setRole(rolesService.getRoles()[0]);
        User user2 = new User("user02@email.com", "Lucas", "Núñez");
        user2.setPassword("user02");
        user2.setRole(rolesService.getRoles()[0]);
        User user3 = new User("user03@email.com", "María", "Rodríguez");
        user3.setPassword("user03");
        user3.setRole(rolesService.getRoles()[0]);
        User user4 = new User("user04@email.com", "Marta", "Almonte");
        user4.setPassword("user04");
        user4.setRole(rolesService.getRoles()[0]);
        User user5 = new User("user05@email.com", "Pelayo", "Valdes");
        user5.setPassword("user05");
        user5.setRole(rolesService.getRoles()[0]);

        User user6 = new User("user06@email.com", "Alejandro", "Torres");
        user6.setPassword("user06");
        user6.setRole(rolesService.getRoles()[0]);
        User user7 = new User("user07@email.com", "Pablo", "Gaviria");
        user7.setPassword("user07");
        user7.setRole(rolesService.getRoles()[0]);
        User user8 = new User("user08@email.com", "Pedro", "González");
        user8.setPassword("user08");
        user8.setRole(rolesService.getRoles()[0]);
        User user9 = new User("user09@email.com", "Fernando", "Torres");
        user9.setPassword("user09");
        user9.setRole(rolesService.getRoles()[0]);
        User user10 = new User("user10@email.com", "Sergio", "Castillo");
        user10.setPassword("user10");
        user10.setRole(rolesService.getRoles()[0]);

        User user11 = new User("user11@email.com", "Armando", "Guiri");
        user11.setPassword("user11");
        user11.setRole(rolesService.getRoles()[0]);
        User user12 = new User("user12@email.com", "Beltrán", "Gómez");
        user12.setPassword("user12");
        user12.setRole(rolesService.getRoles()[0]);
        User user13 = new User("user13@email.com", "Tomás", "Albizu");
        user13.setPassword("user13");
        user13.setRole(rolesService.getRoles()[0]);
        User user14 = new User("user14@email.com", "Carmen", "Galán");
        user14.setPassword("user14");
        user14.setRole(rolesService.getRoles()[0]);
        User user15 = new User("user15@email.com", "Aarón", "Lada");
        user15.setPassword("user15");
        user15.setRole(rolesService.getRoles()[0]);

        User admin = new User("admin@email.com", "SDI", "Admin");
        admin.setPassword("admin");
        admin.setRole(rolesService.getRoles()[1]);

        usersService.addUser(user1);
        usersService.addUser(user2);
        usersService.addUser(user3);
        usersService.addUser(user4);
        usersService.addUser(user5);
        usersService.addUser(user6);
        usersService.addUser(user7);
        usersService.addUser(user8);
        usersService.addUser(user9);
        usersService.addUser(user10);
        usersService.addUser(user11);
        usersService.addUser(user12);
        usersService.addUser(user13);
        usersService.addUser(user14);
        usersService.addUser(user15);
        usersService.addUser(admin);

        // Creamos 10 publicaciones por usuario
        // Publicaciones user1
        Publication p1 = new Publication("Publi 1", "Mi primera publicación", user1, LocalDate.now());
        Publication p2 = new Publication("Publi 2", "Mi segunda publicación", user1, LocalDate.now());
        Publication p3 = new Publication("Publi 3", "Mi tercera publicación", user1, LocalDate.now());
        Publication p4 = new Publication("Publi 4", "Mi cuarta publicación", user1, LocalDate.now());
        Publication p5 = new Publication("Publi 5", "Mi quinta publicación", user1, LocalDate.now());
        Publication p6 = new Publication("Publi 6", "Mi sexta publicación", user1, LocalDate.now());
        Publication p7 = new Publication("Publi 7", "Mi séptima publicación", user1, LocalDate.now());
        Publication p8 = new Publication("Publi 8", "Mi octava publicación", user1, LocalDate.now());
        Publication p9 = new Publication("Publi 9", "Mi novena publicación", user1, LocalDate.now());
        Publication p10 = new Publication("Publi 10", "Mi décima publicación", user1, LocalDate.now());
        // Publicaciones user2
        Publication p11 = new Publication("Publi 1", "Mi primera publicación", user2, LocalDate.now());
        Publication p12 = new Publication("Publi 2", "Mi segunda publicación", user2, LocalDate.now());
        Publication p13 = new Publication("Publi 3", "Mi tercera publicación", user2, LocalDate.now());
        Publication p14 = new Publication("Publi 4", "Mi cuarta publicación", user2, LocalDate.now());
        Publication p15 = new Publication("Publi 5", "Mi quinta publicación", user2, LocalDate.now());
        Publication p16 = new Publication("Publi 6", "Mi sexta publicación", user2, LocalDate.now());
        Publication p17 = new Publication("Publi 7", "Mi séptima publicación", user2, LocalDate.now());
        Publication p18 = new Publication("Publi 8", "Mi octava publicación", user2, LocalDate.now());
        Publication p19 = new Publication("Publi 9", "Mi novena publicación", user2, LocalDate.now());
        Publication p20 = new Publication("Publi 10", "Mi décima publicación", user2, LocalDate.now());
        // Publicaciones user3
        Publication p21 = new Publication("Publi 1", "Mi primera publicación", user3, LocalDate.now());
        Publication p22 = new Publication("Publi 2", "Mi segunda publicación", user3, LocalDate.now());
        Publication p23 = new Publication("Publi 3", "Mi tercera publicación", user3, LocalDate.now());
        Publication p24 = new Publication("Publi 4", "Mi cuarta publicación", user3, LocalDate.now());
        Publication p25 = new Publication("Publi 5", "Mi quinta publicación", user3, LocalDate.now());
        Publication p26 = new Publication("Publi 6", "Mi sexta publicación", user3, LocalDate.now());
        Publication p27 = new Publication("Publi 7", "Mi séptima publicación", user3, LocalDate.now());
        Publication p28 = new Publication("Publi 8", "Mi octava publicación", user3, LocalDate.now());
        Publication p29 = new Publication("Publi 9", "Mi novena publicación", user3, LocalDate.now());
        Publication p30 = new Publication("Publi 10", "Mi décima publicación", user3, LocalDate.now());
        // Publicaciones user4
        Publication p31 = new Publication("Publi 1", "Mi primera publicación", user4, LocalDate.now());
        Publication p32 = new Publication("Publi 2", "Mi segunda publicación", user4, LocalDate.now());
        Publication p33 = new Publication("Publi 3", "Mi tercera publicación", user4, LocalDate.now());
        Publication p34 = new Publication("Publi 4", "Mi cuarta publicación", user4, LocalDate.now());
        Publication p35 = new Publication("Publi 5", "Mi quinta publicación", user4, LocalDate.now());
        Publication p36 = new Publication("Publi 6", "Mi sexta publicación", user4, LocalDate.now());
        Publication p37 = new Publication("Publi 7", "Mi séptima publicación", user4, LocalDate.now());
        Publication p38 = new Publication("Publi 8", "Mi octava publicación", user4, LocalDate.now());
        Publication p39 = new Publication("Publi 9", "Mi novena publicación", user4, LocalDate.now());
        Publication p40 = new Publication("Publi 10", "Mi décima publicación", user4, LocalDate.now());
        // Publicaciones user5
        Publication p41 = new Publication("Publi 1", "Mi primera publicación", user5, LocalDate.now());
        Publication p42 = new Publication("Publi 2", "Mi segunda publicación", user5, LocalDate.now());
        Publication p43 = new Publication("Publi 3", "Mi tercera publicación", user5, LocalDate.now());
        Publication p44 = new Publication("Publi 4", "Mi cuarta publicación", user5, LocalDate.now());
        Publication p45 = new Publication("Publi 5", "Mi quinta publicación", user5, LocalDate.now());
        Publication p46 = new Publication("Publi 6", "Mi sexta publicación", user5, LocalDate.now());
        Publication p47 = new Publication("Publi 7", "Mi séptima publicación", user5, LocalDate.now());
        Publication p48 = new Publication("Publi 8", "Mi octava publicación", user5, LocalDate.now());
        Publication p49 = new Publication("Publi 9", "Mi novena publicación", user5, LocalDate.now());
        Publication p50 = new Publication("Publi 10", "Mi décima publicación", user5, LocalDate.now());
        // Publicaciones user6
        Publication p51 = new Publication("Publi 1", "Mi primera publicación", user6, LocalDate.now());
        Publication p52 = new Publication("Publi 2", "Mi segunda publicación", user6, LocalDate.now());
        Publication p53 = new Publication("Publi 3", "Mi tercera publicación", user6, LocalDate.now());
        Publication p54 = new Publication("Publi 4", "Mi cuarta publicación", user6, LocalDate.now());
        Publication p55 = new Publication("Publi 5", "Mi quinta publicación", user6, LocalDate.now());
        Publication p56 = new Publication("Publi 6", "Mi sexta publicación", user6, LocalDate.now());
        Publication p57 = new Publication("Publi 7", "Mi séptima publicación", user6, LocalDate.now());
        Publication p58 = new Publication("Publi 8", "Mi octava publicación", user6, LocalDate.now());
        Publication p59 = new Publication("Publi 9", "Mi novena publicación", user6, LocalDate.now());
        Publication p60 = new Publication("Publi 10", "Mi décima publicación", user6, LocalDate.now());
        // Publicaciones user7
        Publication p61 = new Publication("Publi 1", "Mi primera publicación", user7, LocalDate.now());
        Publication p62 = new Publication("Publi 2", "Mi segunda publicación", user7, LocalDate.now());
        Publication p63 = new Publication("Publi 3", "Mi tercera publicación", user7, LocalDate.now());
        Publication p64 = new Publication("Publi 4", "Mi cuarta publicación", user7, LocalDate.now());
        Publication p65 = new Publication("Publi 5", "Mi quinta publicación", user7, LocalDate.now());
        Publication p66 = new Publication("Publi 6", "Mi sexta publicación", user7, LocalDate.now());
        Publication p67 = new Publication("Publi 7", "Mi séptima publicación", user7, LocalDate.now());
        Publication p68 = new Publication("Publi 8", "Mi octava publicación", user7, LocalDate.now());
        Publication p69 = new Publication("Publi 9", "Mi novena publicación", user7, LocalDate.now());
        Publication p70 = new Publication("Publi 10", "Mi décima publicación", user7, LocalDate.now());
        // Publicaciones user8
        Publication p71 = new Publication("Publi 1", "Mi primera publicación", user8, LocalDate.now());
        Publication p72 = new Publication("Publi 2", "Mi segunda publicación", user8, LocalDate.now());
        Publication p73 = new Publication("Publi 3", "Mi tercera publicación", user8, LocalDate.now());
        Publication p74 = new Publication("Publi 4", "Mi cuarta publicación", user8, LocalDate.now());
        Publication p75 = new Publication("Publi 5", "Mi quinta publicación", user8, LocalDate.now());
        Publication p76 = new Publication("Publi 6", "Mi sexta publicación", user8, LocalDate.now());
        Publication p77 = new Publication("Publi 7", "Mi séptima publicación", user8, LocalDate.now());
        Publication p78 = new Publication("Publi 8", "Mi octava publicación", user8, LocalDate.now());
        Publication p79 = new Publication("Publi 9", "Mi novena publicación", user8, LocalDate.now());
        Publication p80 = new Publication("Publi 10", "Mi décima publicación", user8, LocalDate.now());
        // Publicaciones user9
        Publication p81 = new Publication("Publi 1", "Mi primera publicación", user9, LocalDate.now());
        Publication p82 = new Publication("Publi 2", "Mi segunda publicación", user9, LocalDate.now());
        Publication p83 = new Publication("Publi 3", "Mi tercera publicación", user9, LocalDate.now());
        Publication p84 = new Publication("Publi 4", "Mi cuarta publicación", user9, LocalDate.now());
        Publication p85 = new Publication("Publi 5", "Mi quinta publicación", user9, LocalDate.now());
        Publication p86 = new Publication("Publi 6", "Mi sexta publicación", user9, LocalDate.now());
        Publication p87 = new Publication("Publi 7", "Mi séptima publicación", user9, LocalDate.now());
        Publication p88 = new Publication("Publi 8", "Mi octava publicación", user9, LocalDate.now());
        Publication p89 = new Publication("Publi 9", "Mi novena publicación", user9, LocalDate.now());
        Publication p90 = new Publication("Publi 10", "Mi décima publicación", user9, LocalDate.now());
        // Publicaciones user10
        Publication p91 = new Publication("Publi 1", "Mi primera publicación", user10, LocalDate.now());
        Publication p92 = new Publication("Publi 2", "Mi segunda publicación", user10, LocalDate.now());
        Publication p93 = new Publication("Publi 3", "Mi tercera publicación", user10, LocalDate.now());
        Publication p94 = new Publication("Publi 4", "Mi cuarta publicación", user10, LocalDate.now());
        Publication p95 = new Publication("Publi 5", "Mi quinta publicación", user10, LocalDate.now());
        Publication p96 = new Publication("Publi 6", "Mi sexta publicación", user10, LocalDate.now());
        Publication p97 = new Publication("Publi 7", "Mi séptima publicación", user10, LocalDate.now());
        Publication p98 = new Publication("Publi 8", "Mi octava publicación", user10, LocalDate.now());
        Publication p99 = new Publication("Publi 9", "Mi novena publicación", user10, LocalDate.now());
        Publication p100 = new Publication("Publi 10", "Mi décima publicación", user10, LocalDate.now());
        // Publicaciones user11
        Publication p101 = new Publication("Publi 1", "Mi primera publicación", user11, LocalDate.now());
        Publication p102 = new Publication("Publi 2", "Mi segunda publicación", user11, LocalDate.now());
        Publication p103 = new Publication("Publi 3", "Mi tercera publicación", user11, LocalDate.now());
        Publication p104 = new Publication("Publi 4", "Mi cuarta publicación", user11, LocalDate.now());
        Publication p105 = new Publication("Publi 5", "Mi quinta publicación", user11, LocalDate.now());
        Publication p106 = new Publication("Publi 6", "Mi sexta publicación", user11, LocalDate.now());
        Publication p107 = new Publication("Publi 7", "Mi séptima publicación", user11, LocalDate.now());
        Publication p108 = new Publication("Publi 8", "Mi octava publicación", user11, LocalDate.now());
        Publication p109 = new Publication("Publi 9", "Mi novena publicación", user11, LocalDate.now());
        Publication p110 = new Publication("Publi 10", "Mi décima publicación", user11, LocalDate.now());
        // Publicaciones user12
        Publication p111 = new Publication("Publi 1", "Mi primera publicación", user12, LocalDate.now());
        Publication p112 = new Publication("Publi 2", "Mi segunda publicación", user12, LocalDate.now());
        Publication p113 = new Publication("Publi 3", "Mi tercera publicación", user12, LocalDate.now());
        Publication p114 = new Publication("Publi 4", "Mi cuarta publicación", user12, LocalDate.now());
        Publication p115 = new Publication("Publi 5", "Mi quinta publicación", user12, LocalDate.now());
        Publication p116 = new Publication("Publi 6", "Mi sexta publicación", user12, LocalDate.now());
        Publication p117 = new Publication("Publi 7", "Mi séptima publicación", user12, LocalDate.now());
        Publication p118 = new Publication("Publi 8", "Mi octava publicación", user12, LocalDate.now());
        Publication p119 = new Publication("Publi 9", "Mi novena publicación", user12, LocalDate.now());
        Publication p120 = new Publication("Publi 10", "Mi décima publicación", user12, LocalDate.now());
        // Publicaciones user13
        Publication p121 = new Publication("Publi 1", "Mi primera publicación", user13, LocalDate.now());
        Publication p122 = new Publication("Publi 2", "Mi segunda publicación", user13, LocalDate.now());
        Publication p123 = new Publication("Publi 3", "Mi tercera publicación", user13, LocalDate.now());
        Publication p124 = new Publication("Publi 4", "Mi cuarta publicación", user13, LocalDate.now());
        Publication p125 = new Publication("Publi 5", "Mi quinta publicación", user13, LocalDate.now());
        Publication p126 = new Publication("Publi 6", "Mi sexta publicación", user13, LocalDate.now());
        Publication p127 = new Publication("Publi 7", "Mi séptima publicación", user13, LocalDate.now());
        Publication p128 = new Publication("Publi 8", "Mi octava publicación", user13, LocalDate.now());
        Publication p129 = new Publication("Publi 9", "Mi novena publicación", user13, LocalDate.now());
        Publication p130 = new Publication("Publi 10", "Mi décima publicación", user13, LocalDate.now());
        // Publicaciones user14
        Publication p131 = new Publication("Publi 1", "Mi primera publicación", user14, LocalDate.now());
        Publication p132 = new Publication("Publi 2", "Mi segunda publicación", user14, LocalDate.now());
        Publication p133 = new Publication("Publi 3", "Mi tercera publicación", user14, LocalDate.now());
        Publication p134 = new Publication("Publi 4", "Mi cuarta publicación", user14, LocalDate.now());
        Publication p135 = new Publication("Publi 5", "Mi quinta publicación", user14, LocalDate.now());
        Publication p136 = new Publication("Publi 6", "Mi sexta publicación", user14, LocalDate.now());
        Publication p137 = new Publication("Publi 7", "Mi séptima publicación", user14, LocalDate.now());
        Publication p138 = new Publication("Publi 8", "Mi octava publicación", user14, LocalDate.now());
        Publication p139 = new Publication("Publi 9", "Mi novena publicación", user14, LocalDate.now());
        Publication p140 = new Publication("Publi 10", "Mi décima publicación", user14, LocalDate.now());
        // Publicaciones user15
        Publication p141 = new Publication("Publi 1", "Mi primera publicación", user15, LocalDate.now());
        Publication p142 = new Publication("Publi 2", "Mi segunda publicación", user15, LocalDate.now());
        Publication p143 = new Publication("Publi 3", "Mi tercera publicación", user15, LocalDate.now());
        Publication p144 = new Publication("Publi 4", "Mi cuarta publicación", user15, LocalDate.now());
        Publication p145 = new Publication("Publi 5", "Mi quinta publicación", user15, LocalDate.now());
        Publication p146 = new Publication("Publi 6", "Mi sexta publicación", user15, LocalDate.now());
        Publication p147 = new Publication("Publi 7", "Mi séptima publicación", user15, LocalDate.now());
        Publication p148 = new Publication("Publi 8", "Mi octava publicación", user15, LocalDate.now());
        Publication p149 = new Publication("Publi 9", "Mi novena publicación", user15, LocalDate.now());
        Publication p150 = new Publication("Publi 10", "Mi décima publicación", user15, LocalDate.now());

        // Añadimos las publicaciones a la bd
        // User1
        publicationsService.addPublication(p1);
        publicationsService.addPublication(p2);
        publicationsService.addPublication(p3);
        publicationsService.addPublication(p4);
        publicationsService.addPublication(p5);
        publicationsService.addPublication(p6);
        publicationsService.addPublication(p7);
        publicationsService.addPublication(p8);
        publicationsService.addPublication(p9);
        publicationsService.addPublication(p10);
        // User2
        publicationsService.addPublication(p11);
        publicationsService.addPublication(p12);
        publicationsService.addPublication(p13);
        publicationsService.addPublication(p14);
        publicationsService.addPublication(p15);
        publicationsService.addPublication(p16);
        publicationsService.addPublication(p17);
        publicationsService.addPublication(p18);
        publicationsService.addPublication(p19);
        publicationsService.addPublication(p20);
        // User3
        publicationsService.addPublication(p21);
        publicationsService.addPublication(p22);
        publicationsService.addPublication(p23);
        publicationsService.addPublication(p24);
        publicationsService.addPublication(p25);
        publicationsService.addPublication(p26);
        publicationsService.addPublication(p27);
        publicationsService.addPublication(p28);
        publicationsService.addPublication(p29);
        publicationsService.addPublication(p30);
        // User4
        publicationsService.addPublication(p31);
        publicationsService.addPublication(p32);
        publicationsService.addPublication(p33);
        publicationsService.addPublication(p34);
        publicationsService.addPublication(p35);
        publicationsService.addPublication(p36);
        publicationsService.addPublication(p37);
        publicationsService.addPublication(p38);
        publicationsService.addPublication(p39);
        publicationsService.addPublication(p40);
        // User5
        publicationsService.addPublication(p41);
        publicationsService.addPublication(p42);
        publicationsService.addPublication(p43);
        publicationsService.addPublication(p44);
        publicationsService.addPublication(p45);
        publicationsService.addPublication(p46);
        publicationsService.addPublication(p47);
        publicationsService.addPublication(p48);
        publicationsService.addPublication(p49);
        publicationsService.addPublication(p50);
        // User6
        publicationsService.addPublication(p51);
        publicationsService.addPublication(p52);
        publicationsService.addPublication(p53);
        publicationsService.addPublication(p54);
        publicationsService.addPublication(p55);
        publicationsService.addPublication(p56);
        publicationsService.addPublication(p57);
        publicationsService.addPublication(p58);
        publicationsService.addPublication(p59);
        publicationsService.addPublication(p60);
        // User7
        publicationsService.addPublication(p61);
        publicationsService.addPublication(p62);
        publicationsService.addPublication(p63);
        publicationsService.addPublication(p64);
        publicationsService.addPublication(p65);
        publicationsService.addPublication(p66);
        publicationsService.addPublication(p67);
        publicationsService.addPublication(p68);
        publicationsService.addPublication(p69);
        publicationsService.addPublication(p70);
        // User8
        publicationsService.addPublication(p71);
        publicationsService.addPublication(p72);
        publicationsService.addPublication(p73);
        publicationsService.addPublication(p74);
        publicationsService.addPublication(p75);
        publicationsService.addPublication(p76);
        publicationsService.addPublication(p77);
        publicationsService.addPublication(p78);
        publicationsService.addPublication(p79);
        publicationsService.addPublication(p80);
        // User9
        publicationsService.addPublication(p81);
        publicationsService.addPublication(p82);
        publicationsService.addPublication(p83);
        publicationsService.addPublication(p84);
        publicationsService.addPublication(p85);
        publicationsService.addPublication(p86);
        publicationsService.addPublication(p87);
        publicationsService.addPublication(p88);
        publicationsService.addPublication(p89);
        publicationsService.addPublication(p90);
        // User10
        publicationsService.addPublication(p91);
        publicationsService.addPublication(p92);
        publicationsService.addPublication(p93);
        publicationsService.addPublication(p94);
        publicationsService.addPublication(p95);
        publicationsService.addPublication(p96);
        publicationsService.addPublication(p97);
        publicationsService.addPublication(p98);
        publicationsService.addPublication(p99);
        publicationsService.addPublication(p100);
        // User11
        publicationsService.addPublication(p101);
        publicationsService.addPublication(p102);
        publicationsService.addPublication(p103);
        publicationsService.addPublication(p104);
        publicationsService.addPublication(p105);
        publicationsService.addPublication(p106);
        publicationsService.addPublication(p107);
        publicationsService.addPublication(p108);
        publicationsService.addPublication(p109);
        publicationsService.addPublication(p110);
        // User12
        publicationsService.addPublication(p111);
        publicationsService.addPublication(p112);
        publicationsService.addPublication(p113);
        publicationsService.addPublication(p114);
        publicationsService.addPublication(p115);
        publicationsService.addPublication(p116);
        publicationsService.addPublication(p117);
        publicationsService.addPublication(p118);
        publicationsService.addPublication(p119);
        publicationsService.addPublication(p120);
        // User13
        publicationsService.addPublication(p121);
        publicationsService.addPublication(p122);
        publicationsService.addPublication(p123);
        publicationsService.addPublication(p124);
        publicationsService.addPublication(p125);
        publicationsService.addPublication(p126);
        publicationsService.addPublication(p127);
        publicationsService.addPublication(p128);
        publicationsService.addPublication(p129);
        publicationsService.addPublication(p130);
        // User14
        publicationsService.addPublication(p131);
        publicationsService.addPublication(p132);
        publicationsService.addPublication(p133);
        publicationsService.addPublication(p134);
        publicationsService.addPublication(p135);
        publicationsService.addPublication(p136);
        publicationsService.addPublication(p137);
        publicationsService.addPublication(p138);
        publicationsService.addPublication(p139);
        publicationsService.addPublication(p140);
        // User15
        publicationsService.addPublication(p141);
        publicationsService.addPublication(p142);
        publicationsService.addPublication(p143);
        publicationsService.addPublication(p144);
        publicationsService.addPublication(p145);
        publicationsService.addPublication(p146);
        publicationsService.addPublication(p147);
        publicationsService.addPublication(p148);
        publicationsService.addPublication(p149);
        publicationsService.addPublication(p150);

        // Creamos amistades entre usuarios
        relationshipService.addDuplicated(new Relationship(user1, user2, true));
        relationshipService.addDuplicated(new Relationship(user1, user3, true));
        relationshipService.addDuplicated(new Relationship(user1, user7, true));
        relationshipService.addDuplicated(new Relationship(user1, user10, true));
        relationshipService.addDuplicated(new Relationship(user1, user12, true));
        relationshipService.addDuplicated(new Relationship(user2, user3, true));
        relationshipService.addDuplicated(new Relationship(user2, user4, true));
        relationshipService.addDuplicated(new Relationship(user2, user7, true));
        relationshipService.addDuplicated(new Relationship(user3, user10, true));
        relationshipService.addDuplicated(new Relationship(user3, user12, true));
        relationshipService.addDuplicated(new Relationship(user3, user9, true));
        relationshipService.addDuplicated(new Relationship(user3, user4, true));
        relationshipService.addDuplicated(new Relationship(user4, user6, true));
        relationshipService.addDuplicated(new Relationship(user4, user7, true));
        relationshipService.addDuplicated(new Relationship(user4, user9, true));

        relationshipService.add(new Relationship(user2, user15, false));
        relationshipService.add(new Relationship(user1, user14, false));
        relationshipService.add(new Relationship(user2, user14, false));
        relationshipService.add(new Relationship(user3, user14, false));
    }

    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {

    }

    //Al finalizar la última prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }

    // PR01 -> registrarse como usuario con datos correctos
    @Test
    @Order(1)
    void PR01() {
        PO_PrivateView.signup(driver, "name@email.com", "Jorge", "Pérez", "123456", "123456", "Usuarios");
        PO_PrivateView.logout(driver);
    }

    // PR02A -> intentar registrarse como usuario con email vacío, luego nombre vacío y por último, apellidos vacíos
    @Test
    @Order(2)
    void PR02() {
        PO_PrivateView.signup(driver, "", "Jorge", "Pérez", "123456", "123456", "Regístrate como usuario");
        PO_PrivateView.signup(driver, "jorge@uniovi.es", "", "Pérez", "123456", "123456", "Regístrate como usuario");
        PO_PrivateView.signup(driver, "jorge@uniovi.es", "Jorge", "", "123456", "123456", "Regístrate como usuario");
    }

    // PR03 -> intentar registrarse como usuario con contraseñas distintas
    @Test
    @Order(3)
    void PR03() {
        PO_PrivateView.signup(driver, "jorge@uniovi.es", "Jorge", "Pérez", "12345", "123456", "Las contraseñas no coinciden.");
    }

    // PR04 -> intentar registrarse como usuario con email ya existente
    @Test
    @Order(4)
    void PR04() {
        PO_PrivateView.signup(driver, "user01@email.com", "Jorge", "Pérez", "12345", "12345", "Este email ya existe.");
    }

    // PR05 -> inicio de sesión con datos válidos (administrador)
    @Test
    @Order(5)
    void PR05() {
        PO_PrivateView.login(driver, "admin@email.com", "admin", "Usuarios");
        PO_PrivateView.logout(driver);
    }

    // PR06 -> inicio de sesión con datos válidos (usuario estándar)
    @Test
    @Order(6)
    void PR06() {
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");
        PO_PrivateView.logout(driver);
    }

    // PR07 -> inicio de sesión con datos inválidos (usuario estándar, campo email y contraseña vacíos)
    @Test
    @Order(7)
    void PR07() {
        PO_PrivateView.login(driver, "", "", "Identifícate");
    }

    // PR08 -> inicio de sesión con datos inválidos (usuario estándar, email existente, pero contraseña incorrecta)
    @Test
    @Order(8)
    void PR08() {
        PO_PrivateView.login(driver, "user01@email.com", "user02", "El usuario y contraseña son inválidos.");
    }

    // PR09 -> Hacer clic en la opción de salir de sesión y comprobar que se redirige a
    //          la página de inicio de sesión (Login)
    @Test
    @Order(9)
    void PR09() {
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");
        PO_PrivateView.logout(driver);
        // comprobar que ha salido
        String checkText = "Identifícate";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    // PR10 -> Comprobar que el botón cerrar sesión no está visible si el usuario no está autenticado
    @Test
    @Order(10)
    void PR10() {
        SeleniumUtils.textIsNotPresentOnPage(driver, "Desconectar");
    }

    // PR11 -> Mostrar el listado de usuarios y comprobar que se muestran todos los que existen en el sistema
    @Test
    @Order(11)
    void PR11() {
        // ir al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // rellenar el formulario como administrador
        PO_LoginView.fillLoginForm(driver, "admin@email.com", "admin");
        List<WebElement> elementsNav = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elementsNav.get(0).click();

        // Comprobamos el numero de usuarios mostrados en la primera página
        List<WebElement> elements1 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements1.size() == 5);

        // Comprobamos el numero de usuarios mostrados en la segunda página
        PO_PrivateView.goToNextPage(driver);
        List<WebElement> elements2 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        assertTrue(elements2.size() == 5);

        // Comprobamos el numero de usuarios mostrados en la tercera página
        PO_PrivateView.goToNextPage(driver);
        List<WebElement> elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        assertTrue(elements3.size() == 5);

    }

    // PR13. Ir a la lista de usuarios, borrar el primer usuario de la lista,
    // comprobar que la lista se actualiza y que el usuario desaparece.
    @Test
    @Order(12)
    public void PR12() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "admin@email.com", "admin");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Guardamos los datos del primer usuario
        List<WebElement> elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        String previousText = elements3.get(0).getText();

        // Seleccionamos el primer usuario
        List<WebElement> elements2 = driver.findElements(By.name("noSelected"));
        elements2.get(0).click();

        // Pulsamos el botón de borrar
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@href, 'user/delete')]");
        elements.get(0).click();

        // Comprobamos que se ha borrado el primer usuario ya que ahora el texto de el primer elemento no coincidirá
        // con el primer elemento anterior, que se ha borrado.
        elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        assertFalse(elements3.get(0).getText().equals(previousText));

    }

    // PR13. Ir a la lista de usuarios, borrar el último usuario de la lista, comprobar que la lista se actualiza
    // y dicho usuario desaparece.
    @Test
    @Order(13)
    public void PR13() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "admin@email.com", "admin");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        //Avanzamos dos páginas
        PO_PrivateView.goToNextPage(driver);
        PO_PrivateView.goToNextPage(driver);

        // Guardamos los datos del ultimo usuario
        List<WebElement> elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        int size = elements3.size();
        String previousText = elements3.get(size - 1).getText();

        // Seleccionamos el ultimo usuario
        List<WebElement> elements2 = driver.findElements(By.name("noSelected"));
        elements2.get(size - 1).click();

        // Pulsamos el botón de borrar
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@href, 'user/delete')]");
        elements.get(0).click();

        // Comprobamos que se ha borrado el último usuario ya que ahora el texto de el primer elemento no coincidirá
        // con el último elemento anterior, que se ha borrado.
        elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        assertFalse(elements3.get(size - 1).getText().equals(previousText));

    }

    // PR14. Ir a la lista de usuarios, borrar 3 usuarios, comprobar que la lista se actualiza y dichos usuarios
    //  desaparecen.
    @Test
    @Order(14)
    public void PR14() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "admin@email.com", "admin");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Guardamos los datos de los 3 primeros usuarios
        List<WebElement> elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        String previousText = elements3.get(0).getText();
        String previousText2 = elements3.get(1).getText();
        String previousText3 = elements3.get(2).getText();
        String previousText4 = elements3.get(3).getText();

        // Seleccionamos los tres primeros usuarios
        List<WebElement> elements2 = driver.findElements(By.name("noSelected"));
        elements2.get(0).click();
        elements2 = driver.findElements(By.name("noSelected"));
        elements2.get(0).click();
        elements2 = driver.findElements(By.name("noSelected"));
        elements2.get(0).click();

        // Pulsamos el botón de borrar
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@href, 'user/delete')]");
        elements.get(0).click();

        // Comprobamos que se han borrado los tres últimos usuarios
        elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());


        assertFalse(elements3.get(0).getText() == previousText);
        assertFalse(elements3.get(1).getText() == previousText2);
        assertFalse(elements3.get(2).getText() == previousText3);


        List<WebElement> elements4 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        //Comprobamos que el cuarto elemento ahora se muestra el primero
        System.out.println(previousText4);
        System.out.println(elements4.get(0).getText());
        assertTrue(elements4.get(0).getText().equals(previousText4));

    }

    // PR15. Mostrar el listado de usuarios y comprobar que se muestran todos los que existen en el sistema,
    //  excepto el propio usuario y aquellos que sean Administradores.
    @Test
    @Order(15)
    public void PR15() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        //Comprobamos que el usuario user01 y el administrador no están en la primera página
        SeleniumUtils.textIsNotPresentOnPage(driver, "user01@email.com");
        SeleniumUtils.textIsNotPresentOnPage(driver, "admin@email.com");

        //Comprobamos que el usuario user01 y el administrador no están en la segunda página
        PO_PrivateView.goToNextPage(driver);
        SeleniumUtils.textIsNotPresentOnPage(driver, "user01@email.com");
        SeleniumUtils.textIsNotPresentOnPage(driver, "admin@email.com");

        //Comprobamos que el usuario user01 y el administrador no están en la tercera página
        PO_PrivateView.goToNextPage(driver);
        SeleniumUtils.textIsNotPresentOnPage(driver, "user01@email.com");
        SeleniumUtils.textIsNotPresentOnPage(driver, "admin@email.com");

    }

    // PR16. Hacer una búsqueda con el campo vacío y comprobar que se muestra la página que
    //  corresponde con el listado usuarios existentes en el sistema.
    @Test
    @Order(16)
    public void PR16() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Buscamos una cadena de texto vacia
        PO_SearchView.fillForm(driver, "");

        // Comprobamos el numero de usuarios mostrados en la primera página
        List<WebElement> elements1 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements1.size() == 5);

        // Comprobamos el numero de usuarios mostrados en la segunda página
        PO_PrivateView.goToNextPage(driver);
        List<WebElement> elements2 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements2.size() == 5);

        // Comprobamos el numero de usuarios mostrados en la tercera página
        PO_PrivateView.goToNextPage(driver);
        List<WebElement> elements3 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements3.size() == 4);


    }

    // PR17. Hacer una búsqueda escribiendo en el campo un texto que no exista y comprobar que se
    //  muestra la página que corresponde, con la lista de usuarios vacía.
    @Test
    @Order(17)
    public void PR17() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Buscamos una cadena de texto vacia
        PO_SearchView.fillForm(driver, "noexiste");

        // Comprobamos que la cadena de texto "user" no está presente en la página lo que significa que no se está
        // mostrando ningún usuario
        SeleniumUtils.waitTextIsNotPresentOnPage(driver, "user", PO_View.getTimeout());


    }

    // PR18. Hacer una búsqueda con un texto específico y comprobar que se muestra la página que
    // corresponde, con la lista de usuarios en los que el texto especificado sea parte de su nombre, apellidos o
    // de su email.
    @Test
    @Order(18)
    public void PR18() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Buscamos la cadena de texto "pe"
        PO_SearchView.fillForm(driver, "pe");

        // Comprobamos el numero de usuarios mostrados en la primera página que deberían ser Pedro Díaz, Pelayo Valdes y
        // Pedro González
        List<WebElement> elements1 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements1.size() == 3);

        // Comprobamos que se muestran los usuarios correctos
        SeleniumUtils.textIsPresentOnPage(driver, "Pedro");
        SeleniumUtils.textIsPresentOnPage(driver, "Pelayo");
        SeleniumUtils.textIsPresentOnPage(driver, "Díaz");
        SeleniumUtils.textIsPresentOnPage(driver, "Valdes");
        SeleniumUtils.textIsPresentOnPage(driver, "González");
    }

    // PR19. Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un usuario.
    // Comprobar que la solicitud de amistad aparece en el listado de invitaciones (punto siguiente).
    @Test
    @Order(19)
    public void PR19() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Y pinchamos en el enlace de agregar amigo de Marta
        elements=PO_View.checkElementBy(driver,"free","//a[contains(@id, 'option-addFriend')]");
        elements.get(0).click();

        //Ahora nos desconectamos comprobamos que aparece el menú de registrarse
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "class", "btn btn-primary");

        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user04@email.com", "user04");

        // Vamos a la página para ver las invitaciones
        List<WebElement> elements2 = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'invitations')]/a");
        elements2.get(0).click();

        // Comprobamos que hay 1 invitacion
        elements2 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements2.size() == 1);
        //Ahora nos desconectamos
        loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "class", "btn btn-primary");

    }

    // PR20. Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un
    // usuario al que ya le habíamos enviadola invitación previamente. No debería dejarnos enviar la invitación.
    // Se podría ocultar el botón de enviar invitación o notificar que ya había sido enviada previamente.
    @Test
    @Order(20)
    public void PR20() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list users')]/a");
        elements.get(0).click();

        // Y pinchamos en el enlace de agregar amigo de Lucas Núñez
        List<WebElement> elements2 = PO_View.checkElementBy(driver, "free", "//td[contains(@id,'element-addFriend')]/a");
        assertTrue(elements2.get(0)!=null);

    }

    // PR21. Mostrar el listado de invitaciones de amistad recibidas. Comprobar con un listado que contenga varias
    // invitaciones recibidas.
    @Test
    @Order(21)
    public void PR21() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user14@email.com", "user14");

        //Pinchamos en la opción de menú de Invitaciones
        List<WebElement> elements = PO_View.checkElementBy
                (driver, "free", "//li[contains(@id, 'invitations')]/a");
        elements.get(0).click();


        // Comprobamos el numero de usuarios mostrados en la primera página
        elements = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements.size() == 3);
        //Ahora nos desconectamos comprobamos que aparece el menú de registrarse
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "class", "btn btn-primary");

    }

    // PR22. Sobre el listado de invitaciones recibidas. Hacer clic en el botón/enlace de una de ellas y
    // comprobar que dicha solicitud desaparece del listado de invitaciones.
    @Test
    @Order(22)
    public void PR22() {
        //Vamos al formulario de login.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "user15@email.com", "user15");

        //Pinchamos en la opción de menú de Invitaciones
        List<WebElement> elements = PO_View.checkElementBy
                (driver, "free", "//li[contains(@id, 'invitations')]/a");
        elements.get(0).click();

        //Esperamos a que se muestren los enlaces de paginación la lista de invitaciones
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");

        elements.get(0).click();
        //Y Pinchamos en el enlace de aceptar de la Peticion de amistad de "Lucas"
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@id, 'option-accept')]");
        elements.get(0).click();

        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");
        elements.get(0).click();

        //Y esperamos a que NO aparezca la invitación de "Lucas"
        SeleniumUtils.waitTextIsNotPresentOnPage(driver, "Lucas",PO_View.getTimeout());

        //Ahora nos desconectamos comprobamos que aparece el menú de registrarse
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "class", "btn btn-primary");
    }

    // PR23. Mostrar el listado de amigos de un usuario. Comprobar que el listado contiene los amigos que deben ser.
    @Test
    @Order(23)
    public void PR23() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user04@email.com", "user04");

        // Vamos a la página para ver los usuarios
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'friends-menu')]/a");
        elements.get(0).click();

        // Comprobamos que hay invitaciones
        List<WebElement> elements1 = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elements1.size() > 0);

        // Comprobamos que se muestran los usuarios correctos
        SeleniumUtils.textIsPresentOnPage(driver, "Lucas");
        SeleniumUtils.textIsPresentOnPage(driver, "María");
        SeleniumUtils.textIsPresentOnPage(driver, "Alejandro");
    }

    // PR24. Ir al formulario crear publicaciones, rellenarla con datos válidos y pulsar el botón Submit.
    // Comprobar que la publicación sale en el listado de publicaciones de dicho usuario.
    @Test
    @Order(24)
    public void PR24() {
        // hacemos login
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");

        // comprobar que antes de nada hay 5 publicaciones en la última página
        PO_PrivateView.goToOwnPublications(driver);
        PO_PrivateView.goToLastPage(driver);
        List<WebElement> publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());

        // añadimos una publicación
        PO_PrivateView.addPublication(driver, "title1", "text1");

        // comprobamos que la lista de publicaciones contiene un elemento en la última página
        // (11 publicaciones => 3 páginas, 2 de 5 y la última de 1)
        PO_PrivateView.goToLastPage(driver);
        publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(1, publications.size());
    }

    // PR25. Ir al formulario de crear publicaciones, rellenarla con datos inválidos (campo título vacío)
    // y pulsar el botón Submit. Comprobar que se muestra el mensaje de campo obligatorio.
    @Test
    @Order(25)
    public void PR25() {
        // hacemos login
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");

        // comprobar antes de nada que hay 5 publis en la última página
        PO_PrivateView.goToOwnPublications(driver);
        PO_PrivateView.goToLastPage(driver);
        List<WebElement> publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());

        // intentamos añadir una nota con título vacío
        PO_PrivateView.addPublication(driver, "", "text1");

        // comprobamos que seguimos en la página de creación de publicación y por tanto no se ha creado
        String checkText = "Nueva publicación";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());

        // comprobar que en la lista de publicaciones propias, sólamente hay 10 (5 en la última página)
        PO_PrivateView.goToOwnPublications(driver);
        PO_PrivateView.goToLastPage(driver);
        publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());
    }

    // PR26. Mostrar el listado de publicaciones de un usuario y comprobar que se muestran todas
    // las que existen para dicho usuario.
    @Test
    @Order(26)
    public void PR26() {
        // hacemos login
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");

        // comprobar antes de nada que hay 5 publis por página
        PO_PrivateView.goToOwnPublications(driver);
        PO_PrivateView.goToFirstPage(driver);
        // Comprobamos que la primera pagina tiene 5 publis
        List<WebElement> publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());
        // Comprobamos que la segunda (y ultima) pagina tiene 5 publis
        PO_PrivateView.goToLastPage(driver);
        publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());

    }

    // PR27. Mostrar el listado de publicaciones de un usuario amigo y comprobar que se muestran todas las que
    // existen para dicho usuario.
    @Test
    @Order(27)
    public void PR27() {
        // hacemos login
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");

        PO_PrivateView.goToFriendPublications(driver, "Lucas-user02@email.com");

        // comprobar que hay 5 publis por página
        // Comprobamos que la primera pagina tiene 5 publis
        PO_PrivateView.goToFirstPage(driver);
        List<WebElement> publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());
        // Comprobamos que la segunda (y ultima) pagina tiene 5 publis
        PO_PrivateView.goToLastPage(driver);
        publications = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertEquals(5, publications.size());
    }

    // PR28. Utilizando un acceso vía URL u otra alternativa, tratar de listar las publicaciones de un usuario
    // que no sea amigo del usuario identificado en sesión. Comprobar que el sistema da un error de autorización.
    @Test
    @Order(28)
    public void PR28() {
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");

        driver.navigate().to("http://localhost:8090/publication/list/user08@email.com");

        String checkText = "Usuarios";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    // PR29. Visualizar al menos cuatro páginas en español/inglés/español (comprobando que algunas de las
    // etiquetas cambian al idioma correspondiente).
    // Ejemplo, Página principal/Opciones Principales de Usuario/Listado de Usuarios.
    @Test
    @Order(29)
    public void PR29() {
        // ir a la página de login
        By login = By.id("login-menu");
        driver.findElement(login).click();

        // comprobar que sale el texto Identifícate en Español
        By loginIntro = By.id("login-intro");
        String checkText = driver.findElement(loginIntro).getText();
        Assertions.assertEquals("Identifícate", checkText);

        // pasamos a idioma inglés y comprobamos la misma etiqueta
        PO_PrivateView.changeLanguage(driver, "en");
        loginIntro = By.id("login-intro");
        checkText = driver.findElement(loginIntro).getText();
        Assertions.assertEquals("Identify yourself", checkText);

        // volvemos a idioma español y comprobamos la misma etiqueta
        PO_PrivateView.changeLanguage(driver, "es");
        loginIntro = By.id("login-intro");
        checkText = driver.findElement(loginIntro).getText();
        Assertions.assertEquals("Identifícate", checkText);

        // hacemos login para meternos en la aplicación y vamos a 'mis publicaciones'
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");
        PO_PrivateView.goToOwnPublications(driver);

        // comprobar que sale el título introductorio de publicaciones en español y el texto que le sigue
        By pubIntro = By.id("publication-intro");
        checkText = driver.findElement(pubIntro).getText();
        Assertions.assertEquals("Mis publicaciones", checkText);

        By pubTextIntro = By.id("publication-text-intro");
        checkText = driver.findElement(pubTextIntro).getText();
        Assertions.assertEquals("Estas son las publicaciones almacenadas en el sistema", checkText);

        // pasamos a idioma inglés y comprobamos las mismas etiquetas
        PO_PrivateView.changeLanguage(driver, "en");
        pubIntro = By.id("publication-intro");
        checkText = driver.findElement(pubIntro).getText();
        Assertions.assertEquals("My posts", checkText);

        pubTextIntro = By.id("publication-text-intro");
        checkText = driver.findElement(pubTextIntro).getText();
        Assertions.assertEquals("These are the publications stored in the system", checkText);

        // volvemos a idioma español y comprobamos las mismas etiquetas
        PO_PrivateView.changeLanguage(driver, "es");
        pubIntro = By.id("publication-intro");
        checkText = driver.findElement(pubIntro).getText();
        Assertions.assertEquals("Mis publicaciones", checkText);

        pubTextIntro = By.id("publication-text-intro");
        checkText = driver.findElement(pubTextIntro).getText();
        Assertions.assertEquals("Estas son las publicaciones almacenadas en el sistema", checkText);

        // vamos a 'ver usuarios'
        PO_PrivateView.goToUsersList(driver);

        // comprobar que sale el título introductorio de publicaciones en español y el texto que le sigue
        By userIntro = By.id("user-intro");
        checkText = driver.findElement(userIntro).getText();
        Assertions.assertEquals("Usuarios", checkText);

        By userTextIntro = By.id("user-text-intro");
        checkText = driver.findElement(userTextIntro).getText();
        Assertions.assertEquals("Los usuarios que actualmente figuran en el sistema son los siguientes:", checkText);

        // pasamos a idioma inglés y comprobamos las mismas etiquetas
        PO_PrivateView.changeLanguage(driver, "en");
        userIntro = By.id("user-intro");
        checkText = driver.findElement(userIntro).getText();
        Assertions.assertEquals("Users", checkText);

        userTextIntro = By.id("user-text-intro");
        checkText = driver.findElement(userTextIntro).getText();
        Assertions.assertEquals("The users currently listed in the system are the following:", checkText);

        // volvemos a idioma español y comprobamos las mismas etiquetas
        PO_PrivateView.changeLanguage(driver, "es");
        userIntro = By.id("user-intro");
        checkText = driver.findElement(userIntro).getText();
        Assertions.assertEquals("Usuarios", checkText);

        userTextIntro = By.id("user-text-intro");
        checkText = driver.findElement(userTextIntro).getText();
        Assertions.assertEquals("Los usuarios que actualmente figuran en el sistema son los siguientes:", checkText);

        // comprobar todas las opciones de menú para un usuario normal:
        // español primera vez
        // Home
        checkText = driver.findElement(By.id("home")).getText();
        Assertions.assertEquals("Inicio", checkText);
        // Users List
        checkText = driver.findElement(By.id("list users")).getText();
        Assertions.assertEquals("Ver usuarios", checkText);
        // Publications
        checkText = driver.findElement(By.id("publication-menu")).getText();
        Assertions.assertEquals("Publicaciones", checkText);
        // Create post
        driver.findElement(By.id("publication-menu")).click();
        checkText = driver.findElement(By.id("add-publication")).getText();
        Assertions.assertEquals("Crear publicación", checkText);
        // My posts
        checkText = driver.findElement(By.id("own-publications")).getText();
        Assertions.assertEquals("Mis publicaciones", checkText);
        // Friend posts
        checkText = driver.findElement(By.id("friends-menu")).getText();
        Assertions.assertEquals("Mis amigos", checkText);
        // Invitations
        checkText = driver.findElement(By.id("invitations-menu")).getText();
        Assertions.assertEquals("Invitaciones", checkText);

        // pasamos a inglés
        PO_PrivateView.changeLanguage(driver, "en");
        // Home
        checkText = driver.findElement(By.id("home")).getText();
        Assertions.assertEquals("Home", checkText);
        // Users List
        checkText = driver.findElement(By.id("list users")).getText();
        Assertions.assertEquals("Users list", checkText);
        // Publications
        checkText = driver.findElement(By.id("publication-menu")).getText();
        Assertions.assertEquals("Publications", checkText);
        // Create post
        driver.findElement(By.id("publication-menu")).click();
        checkText = driver.findElement(By.id("add-publication")).getText();
        Assertions.assertEquals("Create post", checkText);
        // My posts
        checkText = driver.findElement(By.id("own-publications")).getText();
        Assertions.assertEquals("My posts", checkText);
        // Friend posts
        checkText = driver.findElement(By.id("friends-menu")).getText();
        Assertions.assertEquals("My friends", checkText);
        // Invitations
        checkText = driver.findElement(By.id("invitations-menu")).getText();
        Assertions.assertEquals("Invitations", checkText);

        // volvemos a español
        PO_PrivateView.changeLanguage(driver, "es");
        // Home
        checkText = driver.findElement(By.id("home")).getText();
        Assertions.assertEquals("Inicio", checkText);
        // Users List
        checkText = driver.findElement(By.id("list users")).getText();
        Assertions.assertEquals("Ver usuarios", checkText);
        // Publications
        checkText = driver.findElement(By.id("publication-menu")).getText();
        Assertions.assertEquals("Publicaciones", checkText);
        // Create post
        driver.findElement(By.id("publication-menu")).click();
        checkText = driver.findElement(By.id("add-publication")).getText();
        Assertions.assertEquals("Crear publicación", checkText);
        // My posts
        checkText = driver.findElement(By.id("own-publications")).getText();
        Assertions.assertEquals("Mis publicaciones", checkText);
        // Friend posts
        checkText = driver.findElement(By.id("friends-menu")).getText();
        Assertions.assertEquals("Mis amigos", checkText);
        // Invitations
        checkText = driver.findElement(By.id("invitations-menu")).getText();
        Assertions.assertEquals("Invitaciones", checkText);
    }

    // PR30. Intentar acceder sin estar autenticado a la opción de listado de usuarios. Se deberá volver al
    //  formulario de login.
    @Test
    @Order(30)
    public void PR30() {
        //Navegamos a la URL para listar usuarios sin habernos autenticado
        driver.navigate().to(URL + "/user/list");

        //Comprobamos que nos redirige al formulario de Login
        SeleniumUtils.textIsPresentOnPage(driver, "Identifícate");
    }

    // PR31. Intentar acceder sin estar autenticado a la opción de listado de invitaciones de amistad recibida
    //      de un usuario estándar. Se deberá volver al formulario de login.
    @Test
    @Order(31)
    public void PR31() {
        //Navegamos a la URL para listar peticiones de amistad sin habernos autenticado
        driver.navigate().to(URL + "/relationship/list");

        //Comprobamos que nos redirige al formulario de Login
        SeleniumUtils.textIsPresentOnPage(driver, "Identifícate");
    }

    // PR32. Estando autenticado como usuario estándar intentar acceder a una opción disponible solo
    //  para usuarios administradores (Añadir menú de auditoria (visualizar logs)). Se deberá indicar un mensaje
    //  de acción prohibida.
    @Test
    @Order(32)
    public void PR32() {
        // hacemos login
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");

        // Vamos a la página para ver los logs
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list logs')]/a");
        elements.get(0).click();

        //Comprobamos que se muestra el mensaje
        SeleniumUtils.textIsPresentOnPage(driver, "Listado de logs sólo está disponible para los administradores");
    }

    // PR33. Estando autenticado como usuario administrador visualizar todos los logs generados en una
    //  serie de interacciones. Esta prueba deberá generar al menos dos interacciones de cada tipo y comprobar
    //  que el listado incluye los logs correspondientes.
    @Test
    @Order(33)
    public void PR33() {
        // Hacemos el primer registro
        PO_PrivateView.signup(driver, "prueba1@email.com", "prueba1", "prueba1", "prueba1",
                "prueba1", "Usuarios");
        // Hacemos el primer LogOut
        PO_PrivateView.logout(driver);

        // Hacemos el segundo registro
        PO_PrivateView.signup(driver, "prueba2@email.com", "prueba2", "prueba2", "prueba2",
                "prueba2", "Usuarios");
        // Hacemos el segundo LogOut
        PO_PrivateView.logout(driver);

        // hacemos el primer error de login
        PO_PrivateView.login(driver, "error@email.com", "user01", "Identifícate");

        // hacemos el segundo error de login
        PO_PrivateView.login(driver, "error@email.com", "user01", "Identifícate");

        // hacemos login
        PO_PrivateView.login(driver, "user01@email.com", "user01", "Usuarios");
        PO_PrivateView.logout(driver);
        // hacemos login
        PO_PrivateView.login(driver, "admin@email.com", "admin", "Usuarios");

        // Vamos a la página para ver los logs
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list logs')]/a");
        elements.get(0).click();

        //Comprobamos que los logs de la página 1 se muestran en el orden correcto
        List<WebElement> page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        Assertions.assertTrue(page.get(0).getText().contains("PET"));
        Assertions.assertTrue(page.get(1).getText().contains("PET"));
        Assertions.assertTrue(page.get(2).getText().contains("LOGIN-EX"));
        Assertions.assertTrue(page.get(3).getText().contains("PET"));
        Assertions.assertTrue(page.get(4).getText().contains("PET"));


        //Comprobamos que los logs de la página 2 se muestran en el orden correcto
        PO_PrivateView.goToNextPage(driver);
        page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());


        Assertions.assertTrue(page.get(0).getText().contains("PET"));
        Assertions.assertTrue(page.get(1).getText().contains("LOGOUT"));
        Assertions.assertTrue(page.get(2).getText().contains("PET"));
        Assertions.assertTrue(page.get(3).getText().contains("PET"));
        Assertions.assertTrue(page.get(4).getText().contains("LOGIN-EX"));


        //Comprobamos que los logs de la página 3 se muestran en el orden correcto
        PO_PrivateView.goToNextPage(driver);
        page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        Assertions.assertTrue(page.get(0).getText().contains("LOGIN-EX"));
        Assertions.assertTrue(page.get(1).getText().contains("PET"));
        Assertions.assertTrue(page.get(2).getText().contains("PET"));
        Assertions.assertTrue(page.get(3).getText().contains("PET"));
        Assertions.assertTrue(page.get(4).getText().contains("LOGIN-ERR"));

        //Comprobamos que los logs de la página 4 se muestran en el orden correcto
        PO_PrivateView.goToNextPage(driver);
        page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        Assertions.assertTrue(page.get(0).getText().contains("LOGIN-ERR"));
        Assertions.assertTrue(page.get(1).getText().contains("PET"));
        Assertions.assertTrue(page.get(2).getText().contains("PET"));
        Assertions.assertTrue(page.get(3).getText().contains("PET"));
        Assertions.assertTrue(page.get(4).getText().contains("LOGIN-ERR"));


        //Comprobamos que los logs de la página 5 se muestran en el orden correcto
        PO_PrivateView.goToNextPage(driver);
        page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        Assertions.assertTrue(page.get(0).getText().contains("LOGIN-ERR"));
        Assertions.assertTrue(page.get(1).getText().contains("PET"));
        Assertions.assertTrue(page.get(2).getText().contains("PET"));
        Assertions.assertTrue(page.get(3).getText().contains("LOGOUT"));
        Assertions.assertTrue(page.get(4).getText().contains("PET"));

        //Comprobamos que los logs de la página 6 se muestran en el orden correcto
        PO_PrivateView.goToNextPage(driver);
        page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        Assertions.assertTrue(page.get(0).getText().contains("PET"));
        Assertions.assertTrue(page.get(1).getText().contains("PET"));
        Assertions.assertTrue(page.get(2).getText().contains("ALTA"));
        Assertions.assertTrue(page.get(3).getText().contains("PET"));
        Assertions.assertTrue(page.get(4).getText().contains("LOGOUT"));

        //Comprobamos que los logs de la página 7 se muestran en el orden correcto
        PO_PrivateView.goToNextPage(driver);
        page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());

        Assertions.assertTrue(page.get(0).getText().contains("LOGOUT"));
        Assertions.assertTrue(page.get(1).getText().contains("PET"));
        Assertions.assertTrue(page.get(2).getText().contains("PET"));
        Assertions.assertTrue(page.get(3).getText().contains("ALTA"));
    }

    // PR34. Estando autenticado como usuario administrador, ir a visualización de logs, pulsar el
    //        botón/enlace borrar logs y comprobar que se eliminan los logs de la base de datos.
    @Test
    @Order(34)
    public void PR34() {
        // Hacemos un registro para llenar el log
        PO_PrivateView.signup(driver, "prueba1@email.com", "prueba1", "prueba1", "prueba1",
                "prueba1", "Usuarios");
        PO_PrivateView.logout(driver);
        // hacemos login como admin
        PO_PrivateView.login(driver, "admin@email.com", "admin", "Usuarios");

        // Vamos a la página para ver los logs
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'list logs')]/a");
        elements.get(0).click();

        //Comprobamos que hay logs en la página 1
        List<WebElement> page = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertTrue(page.size() != 0);

        // Pulsamos el botón de borrar
        List<WebElement> botonBorrar = PO_View.checkElementBy(driver, "free", "//a[contains(@href, 'log/delete')]");
        botonBorrar.get(0).click();

        //Comprobamos que ya no hay logs
        page = PO_PrivateView.waitLoadElementsDontExistBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        Assertions.assertTrue(page.size() == 0);

    }

    // PR35. Estando autenticado como usuario entramos en las publicaciones de un amigo
    //        y recomendam,os una publicacion, y despues nos aseguramos de que aumenta el numero
    //          de recomendaciones
    @Test
    @Order(35)
    public void PR35() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        // Vamos a la página para ver los amigos
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id,'friends-menu')]/a");
        elements.get(0).click();

        // Y pinchamos en el enlace de Lucas
        elements=PO_View.checkElementBy(driver,"free","//a[contains(@id, 'Lucas-user02@email.com')]");
        elements.get(0).click();

        // Y pinchamos en el enlace de recomendar
        elements=PO_View.checkElementBy(driver,"free","//a[contains(@id, 'Publi 1-recomendar')]");
        elements.get(0).click();

        // Obtenemos cuantas veces se recomendo esa publicacion
        elements=PO_View.checkElementBy(driver,"free","//td[contains(@id, 'Publi 1-recomendaciones')]");

        assertTrue(elements.get(0).getText().contains("1"));

        // Comprobamos que no se pueda volver a recomendar
        elements=PO_View.checkElementBy(driver,"free","//td[contains(@id, 'Publi 1')]");
        assertTrue(elements.get(0).getText().contains(""));

    }

    // PR36. Estando autenticado como usuario entramos intentamos recomendar una publicacion de
    //          una persona que no es nuestro amigo
    @Test
    @Order(36)
    public void PR36() {
        // Vamos al formulario de login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        // Rellenamos el formulario.
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");

        driver.navigate().to("http://localhost:8090/publication/list/user08@email.com");

        //Con esto nos muestra que nos llevo a la pagina de usuarios
        SeleniumUtils.textIsPresentOnPage(driver,"Usuarios");
        //Y con esto nos demuestra que no se puede recomendar nada ya que no nos permite ver sus publicaciones
        SeleniumUtils.textIsNotPresentOnPage(driver,"Recomendar");
    }

}
