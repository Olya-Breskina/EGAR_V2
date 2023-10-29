package ru.podgoretskaya.employeeBase.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.podgoretskaya.employeeBase.service.GetAll;
import ru.podgoretskaya.employeeBase.service.GetCard;
import ru.podgoretskaya.employeeBase.service.GetSettlement;
import ru.podgoretskaya.employeeBase.service.SaveInDB;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(APIController.class)
class APIControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    SaveInDB saveInDB;
    @MockBean
    GetCard getCard;
    @MockBean
    GetAll getAll;
    @MockBean
    GetSettlement getSettlement;

    @Test
    void saveInDB() throws Exception {
        mockMvc.perform(post("/base/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                            {
                                                 "lastName": "Ivanov",
                                                 "firstName": "Ivan",
                                                 "middleName": " ",
                                                 "birthdate": "2000-10-23",
                                                 "position": "ANALYST",
                                                 "department": "ACCOUNTING",
                                                 "grade": "JUNIOR",
                                                 "phoneNumber": "9485218612",
                                                 "email": "iivan@mai.ru",
                                                 "occupancy": "REMOTEWORK",
                                                 "workingMode": "FROM_9_TO_18",
                                                 "workExperienceCurrent": 2,
                                                 "salary": 15000
                                            }
                                """))
                .andExpect(status().isOk());
    }

    @Test
    void getCard() throws Exception {
        mockMvc.perform(post("/base/card/352")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getGuide() throws Exception {
        mockMvc.perform(get("/base/guide")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void saveDaysOffWork() throws Exception {
        mockMvc.perform(post("/base/daysOffWork/{id}", 1)//
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                              {
                                                  "date": "2023-10-27"
                                              }
                                """))
                .andExpect(status().isOk());
    }

    @Test
    void saveVacation() throws Exception {
        mockMvc.perform(post("/base/vacation/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                   {
                                        "start": "2023-10-01",
                                        "end": "2023-10-14"
                                   }
                                 """))
                .andExpect(status().isOk());
    }

    @Test
    void saveSickDays() throws Exception {
        mockMvc.perform(post("/base/sickDays/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                        "start": "2023-10-15",
                                        "end": "2023-10-20"
                                    }
                                 """))
                .andExpect(status().isOk());
    }

    @Test
    void getSettlement() throws Exception {
        mockMvc.perform(post("/base/getSettlement/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}