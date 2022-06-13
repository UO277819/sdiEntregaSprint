package com.uniovi.sdientrega173.services;

import java.time.LocalDate;
import javax.annotation.PostConstruct;

import com.uniovi.sdientrega173.entities.Publication;
import com.uniovi.sdientrega173.entities.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdientrega173.entities.User;

@Service
public class InsertSampleDataService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private RelationshipService relationshipService;

    @Autowired
    private PublicationsService publicationsService;

    @PostConstruct
    public void init() {
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

        // Creamos 10 publicaciones por usuario
        // Publicaciones user1
        Publication p1 = new Publication("Publi 1","Mi primera publicación",user1, LocalDate.now());
        Publication p2 = new Publication("Publi 2","Mi segunda publicación",user1,LocalDate.now());
        Publication p3 = new Publication("Publi 3","Mi tercera publicación",user1,LocalDate.now());
        Publication p4 = new Publication("Publi 4","Mi cuarta publicación",user1,LocalDate.now());
        Publication p5 = new Publication("Publi 5","Mi quinta publicación",user1,LocalDate.now());
        Publication p6 = new Publication("Publi 6","Mi sexta publicación",user1,LocalDate.now());
        Publication p7 = new Publication("Publi 7","Mi séptima publicación",user1,LocalDate.now());
        Publication p8 = new Publication("Publi 8","Mi octava publicación",user1,LocalDate.now());
        Publication p9 = new Publication("Publi 9","Mi novena publicación",user1,LocalDate.now());
        Publication p10 = new Publication("Publi 10","Mi décima publicación",user1,LocalDate.now());
        // Publicaciones user2
        Publication p11 = new Publication("Publi 1","Mi primera publicación",user2,LocalDate.now());
        Publication p12 = new Publication("Publi 2","Mi segunda publicación",user2,LocalDate.now());
        Publication p13 = new Publication("Publi 3","Mi tercera publicación",user2,LocalDate.now());
        Publication p14 = new Publication("Publi 4","Mi cuarta publicación",user2,LocalDate.now());
        Publication p15 = new Publication("Publi 5","Mi quinta publicación",user2,LocalDate.now());
        Publication p16 = new Publication("Publi 6","Mi sexta publicación",user2,LocalDate.now());
        Publication p17 = new Publication("Publi 7","Mi séptima publicación",user2,LocalDate.now());
        Publication p18 = new Publication("Publi 8","Mi octava publicación",user2,LocalDate.now());
        Publication p19 = new Publication("Publi 9","Mi novena publicación",user2,LocalDate.now());
        Publication p20 = new Publication("Publi 10","Mi décima publicación",user2,LocalDate.now());
        // Publicaciones user3
        Publication p21 = new Publication("Publi 1","Mi primera publicación",user3,LocalDate.now());
        Publication p22 = new Publication("Publi 2","Mi segunda publicación",user3,LocalDate.now());
        Publication p23 = new Publication("Publi 3","Mi tercera publicación",user3,LocalDate.now());
        Publication p24 = new Publication("Publi 4","Mi cuarta publicación",user3,LocalDate.now());
        Publication p25 = new Publication("Publi 5","Mi quinta publicación",user3,LocalDate.now());
        Publication p26 = new Publication("Publi 6","Mi sexta publicación",user3,LocalDate.now());
        Publication p27 = new Publication("Publi 7","Mi séptima publicación",user3,LocalDate.now());
        Publication p28 = new Publication("Publi 8","Mi octava publicación",user3,LocalDate.now());
        Publication p29 = new Publication("Publi 9","Mi novena publicación",user3,LocalDate.now());
        Publication p30 = new Publication("Publi 10","Mi décima publicación",user3,LocalDate.now());
        // Publicaciones user4
        Publication p31= new Publication("Publi 1","Mi primera publicación",user4,LocalDate.now());
        Publication p32 = new Publication("Publi 2","Mi segunda publicación",user4,LocalDate.now());
        Publication p33 = new Publication("Publi 3","Mi tercera publicación",user4,LocalDate.now());
        Publication p34 = new Publication("Publi 4","Mi cuarta publicación",user4,LocalDate.now());
        Publication p35 = new Publication("Publi 5","Mi quinta publicación",user4,LocalDate.now());
        Publication p36 = new Publication("Publi 6","Mi sexta publicación",user4,LocalDate.now());
        Publication p37 = new Publication("Publi 7","Mi séptima publicación",user4,LocalDate.now());
        Publication p38 = new Publication("Publi 8","Mi octava publicación",user4,LocalDate.now());
        Publication p39 = new Publication("Publi 9","Mi novena publicación",user4,LocalDate.now());
        Publication p40 = new Publication("Publi 10","Mi décima publicación",user4,LocalDate.now());
        // Publicaciones user5
        Publication p41= new Publication("Publi 1","Mi primera publicación",user5,LocalDate.now());
        Publication p42 = new Publication("Publi 2","Mi segunda publicación",user5,LocalDate.now());
        Publication p43 = new Publication("Publi 3","Mi tercera publicación",user5,LocalDate.now());
        Publication p44 = new Publication("Publi 4","Mi cuarta publicación",user5,LocalDate.now());
        Publication p45 = new Publication("Publi 5","Mi quinta publicación",user5,LocalDate.now());
        Publication p46 = new Publication("Publi 6","Mi sexta publicación",user5,LocalDate.now());
        Publication p47 = new Publication("Publi 7","Mi séptima publicación",user5,LocalDate.now());
        Publication p48 = new Publication("Publi 8","Mi octava publicación",user5,LocalDate.now());
        Publication p49 = new Publication("Publi 9","Mi novena publicación",user5,LocalDate.now());
        Publication p50 = new Publication("Publi 10","Mi décima publicación",user5,LocalDate.now());
        // Publicaciones user6
        Publication p51= new Publication("Publi 1","Mi primera publicación",user6,LocalDate.now());
        Publication p52 = new Publication("Publi 2","Mi segunda publicación",user6,LocalDate.now());
        Publication p53 = new Publication("Publi 3","Mi tercera publicación",user6,LocalDate.now());
        Publication p54 = new Publication("Publi 4","Mi cuarta publicación",user6,LocalDate.now());
        Publication p55 = new Publication("Publi 5","Mi quinta publicación",user6,LocalDate.now());
        Publication p56 = new Publication("Publi 6","Mi sexta publicación",user6,LocalDate.now());
        Publication p57 = new Publication("Publi 7","Mi séptima publicación",user6,LocalDate.now());
        Publication p58 = new Publication("Publi 8","Mi octava publicación",user6,LocalDate.now());
        Publication p59 = new Publication("Publi 9","Mi novena publicación",user6,LocalDate.now());
        Publication p60 = new Publication("Publi 10","Mi décima publicación",user6,LocalDate.now());
        // Publicaciones user7
        Publication p61= new Publication("Publi 1","Mi primera publicación",user7,LocalDate.now());
        Publication p62 = new Publication("Publi 2","Mi segunda publicación",user7,LocalDate.now());
        Publication p63 = new Publication("Publi 3","Mi tercera publicación",user7,LocalDate.now());
        Publication p64 = new Publication("Publi 4","Mi cuarta publicación",user7,LocalDate.now());
        Publication p65 = new Publication("Publi 5","Mi quinta publicación",user7,LocalDate.now());
        Publication p66 = new Publication("Publi 6","Mi sexta publicación",user7,LocalDate.now());
        Publication p67 = new Publication("Publi 7","Mi séptima publicación",user7,LocalDate.now());
        Publication p68 = new Publication("Publi 8","Mi octava publicación",user7,LocalDate.now());
        Publication p69 = new Publication("Publi 9","Mi novena publicación",user7,LocalDate.now());
        Publication p70 = new Publication("Publi 10","Mi décima publicación",user7,LocalDate.now());
        // Publicaciones user8
        Publication p71= new Publication("Publi 1","Mi primera publicación",user8,LocalDate.now());
        Publication p72 = new Publication("Publi 2","Mi segunda publicación",user8,LocalDate.now());
        Publication p73 = new Publication("Publi 3","Mi tercera publicación",user8,LocalDate.now());
        Publication p74 = new Publication("Publi 4","Mi cuarta publicación",user8,LocalDate.now());
        Publication p75 = new Publication("Publi 5","Mi quinta publicación",user8,LocalDate.now());
        Publication p76 = new Publication("Publi 6","Mi sexta publicación",user8,LocalDate.now());
        Publication p77 = new Publication("Publi 7","Mi séptima publicación",user8,LocalDate.now());
        Publication p78 = new Publication("Publi 8","Mi octava publicación",user8,LocalDate.now());
        Publication p79 = new Publication("Publi 9","Mi novena publicación",user8,LocalDate.now());
        Publication p80 = new Publication("Publi 10","Mi décima publicación",user8,LocalDate.now());
        // Publicaciones user9
        Publication p81= new Publication("Publi 1","Mi primera publicación",user9,LocalDate.now());
        Publication p82 = new Publication("Publi 2","Mi segunda publicación",user9,LocalDate.now());
        Publication p83 = new Publication("Publi 3","Mi tercera publicación",user9,LocalDate.now());
        Publication p84 = new Publication("Publi 4","Mi cuarta publicación",user9,LocalDate.now());
        Publication p85 = new Publication("Publi 5","Mi quinta publicación",user9,LocalDate.now());
        Publication p86 = new Publication("Publi 6","Mi sexta publicación",user9,LocalDate.now());
        Publication p87 = new Publication("Publi 7","Mi séptima publicación",user9,LocalDate.now());
        Publication p88 = new Publication("Publi 8","Mi octava publicación",user9,LocalDate.now());
        Publication p89 = new Publication("Publi 9","Mi novena publicación",user9,LocalDate.now());
        Publication p90 = new Publication("Publi 10","Mi décima publicación",user9,LocalDate.now());
        // Publicaciones user10
        Publication p91= new Publication("Publi 1","Mi primera publicación",user10,LocalDate.now());
        Publication p92 = new Publication("Publi 2","Mi segunda publicación",user10,LocalDate.now());
        Publication p93 = new Publication("Publi 3","Mi tercera publicación",user10,LocalDate.now());
        Publication p94 = new Publication("Publi 4","Mi cuarta publicación",user10,LocalDate.now());
        Publication p95 = new Publication("Publi 5","Mi quinta publicación",user10,LocalDate.now());
        Publication p96 = new Publication("Publi 6","Mi sexta publicación",user10,LocalDate.now());
        Publication p97 = new Publication("Publi 7","Mi séptima publicación",user10,LocalDate.now());
        Publication p98 = new Publication("Publi 8","Mi octava publicación",user10,LocalDate.now());
        Publication p99 = new Publication("Publi 9","Mi novena publicación",user10,LocalDate.now());
        Publication p100 = new Publication("Publi 10","Mi décima publicación",user10,LocalDate.now());
        // Publicaciones user11
        Publication p101= new Publication("Publi 1","Mi primera publicación",user11,LocalDate.now());
        Publication p102 = new Publication("Publi 2","Mi segunda publicación",user11,LocalDate.now());
        Publication p103 = new Publication("Publi 3","Mi tercera publicación",user11,LocalDate.now());
        Publication p104 = new Publication("Publi 4","Mi cuarta publicación",user11,LocalDate.now());
        Publication p105 = new Publication("Publi 5","Mi quinta publicación",user11,LocalDate.now());
        Publication p106 = new Publication("Publi 6","Mi sexta publicación",user11,LocalDate.now());
        Publication p107 = new Publication("Publi 7","Mi séptima publicación",user11,LocalDate.now());
        Publication p108 = new Publication("Publi 8","Mi octava publicación",user11,LocalDate.now());
        Publication p109 = new Publication("Publi 9","Mi novena publicación",user11,LocalDate.now());
        Publication p110 = new Publication("Publi 10","Mi décima publicación",user11,LocalDate.now());
        // Publicaciones user12
        Publication p111 = new Publication("Publi 1","Mi primera publicación",user12,LocalDate.now());
        Publication p112 = new Publication("Publi 2","Mi segunda publicación",user12,LocalDate.now());
        Publication p113 = new Publication("Publi 3","Mi tercera publicación",user12,LocalDate.now());
        Publication p114 = new Publication("Publi 4","Mi cuarta publicación",user12,LocalDate.now());
        Publication p115 = new Publication("Publi 5","Mi quinta publicación",user12,LocalDate.now());
        Publication p116 = new Publication("Publi 6","Mi sexta publicación",user12,LocalDate.now());
        Publication p117 = new Publication("Publi 7","Mi séptima publicación",user12,LocalDate.now());
        Publication p118 = new Publication("Publi 8","Mi octava publicación",user12,LocalDate.now());
        Publication p119 = new Publication("Publi 9","Mi novena publicación",user12,LocalDate.now());
        Publication p120 = new Publication("Publi 10","Mi décima publicación",user12,LocalDate.now());
        // Publicaciones user13
        Publication p121 = new Publication("Publi 1","Mi primera publicación",user13,LocalDate.now());
        Publication p122 = new Publication("Publi 2","Mi segunda publicación",user13,LocalDate.now());
        Publication p123 = new Publication("Publi 3","Mi tercera publicación",user13,LocalDate.now());
        Publication p124 = new Publication("Publi 4","Mi cuarta publicación",user13,LocalDate.now());
        Publication p125 = new Publication("Publi 5","Mi quinta publicación",user13,LocalDate.now());
        Publication p126 = new Publication("Publi 6","Mi sexta publicación",user13,LocalDate.now());
        Publication p127 = new Publication("Publi 7","Mi séptima publicación",user13,LocalDate.now());
        Publication p128 = new Publication("Publi 8","Mi octava publicación",user13,LocalDate.now());
        Publication p129 = new Publication("Publi 9","Mi novena publicación",user13,LocalDate.now());
        Publication p130 = new Publication("Publi 10","Mi décima publicación",user13,LocalDate.now());
        // Publicaciones user14
        Publication p131 = new Publication("Publi 1","Mi primera publicación",user14,LocalDate.now());
        Publication p132 = new Publication("Publi 2","Mi segunda publicación",user14,LocalDate.now());
        Publication p133 = new Publication("Publi 3","Mi tercera publicación",user14,LocalDate.now());
        Publication p134 = new Publication("Publi 4","Mi cuarta publicación",user14,LocalDate.now());
        Publication p135 = new Publication("Publi 5","Mi quinta publicación",user14,LocalDate.now());
        Publication p136 = new Publication("Publi 6","Mi sexta publicación",user14,LocalDate.now());
        Publication p137 = new Publication("Publi 7","Mi séptima publicación",user14,LocalDate.now());
        Publication p138 = new Publication("Publi 8","Mi octava publicación",user14,LocalDate.now());
        Publication p139 = new Publication("Publi 9","Mi novena publicación",user14,LocalDate.now());
        Publication p140 = new Publication("Publi 10","Mi décima publicación",user14,LocalDate.now());
        // Publicaciones user15
        Publication p141 = new Publication("Publi 1","Mi primera publicación",user15,LocalDate.now());
        Publication p142 = new Publication("Publi 2","Mi segunda publicación",user15,LocalDate.now());
        Publication p143 = new Publication("Publi 3","Mi tercera publicación",user15,LocalDate.now());
        Publication p144 = new Publication("Publi 4","Mi cuarta publicación",user15,LocalDate.now());
        Publication p145 = new Publication("Publi 5","Mi quinta publicación",user15,LocalDate.now());
        Publication p146 = new Publication("Publi 6","Mi sexta publicación",user15,LocalDate.now());
        Publication p147 = new Publication("Publi 7","Mi séptima publicación",user15,LocalDate.now());
        Publication p148 = new Publication("Publi 8","Mi octava publicación",user15,LocalDate.now());
        Publication p149 = new Publication("Publi 9","Mi novena publicación",user15,LocalDate.now());
        Publication p150 = new Publication("Publi 10","Mi décima publicación",user15,LocalDate.now());


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
        relationshipService.addDuplicated(new Relationship(user1,user2,true));
        relationshipService.addDuplicated(new Relationship(user1,user3,true));
        relationshipService.addDuplicated(new Relationship(user1,user7,true));
        relationshipService.addDuplicated(new Relationship(user1,user10,true));
        relationshipService.addDuplicated(new Relationship(user1,user12,true));
        relationshipService.addDuplicated(new Relationship(user9,user1,true));
        relationshipService.addDuplicated(new Relationship(user2,user3,true));
        relationshipService.addDuplicated(new Relationship(user2,user4,true));
        relationshipService.addDuplicated(new Relationship(user2,user7,true));
        relationshipService.addDuplicated(new Relationship(user3,user10,true));
        relationshipService.addDuplicated(new Relationship(user3,user12,true));
        relationshipService.addDuplicated(new Relationship(user3,user9,true));
        relationshipService.addDuplicated(new Relationship(user3,user4,true));
        relationshipService.addDuplicated(new Relationship(user4,user6,true));
        relationshipService.addDuplicated(new Relationship(user4,user7,true));
        relationshipService.addDuplicated(new Relationship(user4,user9,true));
/*
        relationshipService.addDuplicated(new Relationship(user2,user1,true));
        relationshipService.addDuplicated(new Relationship(user3,user1,true));
        relationshipService.addDuplicated(new Relationship(user7,user1,true));
        relationshipService.addDuplicated(new Relationship(user10,user1,true));
        relationshipService.addDuplicated(new Relationship(user12,user1,true));
        relationshipService.addDuplicated(new Relationship(user3,user2,true));
        relationshipService.addDuplicated(new Relationship(user4,user2,true));
        relationshipService.addDuplicated(new Relationship(user7,user2,true));
        relationshipService.addDuplicated(new Relationship(user10,user3,true));
        relationshipService.addDuplicated(new Relationship(user12,user3,true));
        relationshipService.addDuplicated(new Relationship(user9,user3,true));
        relationshipService.addDuplicated(new Relationship(user4,user3,true));
        relationshipService.addDuplicated(new Relationship(user6,user4,true));
        relationshipService.addDuplicated(new Relationship(user7,user4,true));
        relationshipService.addDuplicated(new Relationship(user9,user4,true));
        */
    }
}
