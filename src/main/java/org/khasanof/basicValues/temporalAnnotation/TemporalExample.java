package org.khasanof.basicValues.temporalAnnotation;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

/**
 * Author: Nurislom
 * <br/>
 * Date: 1/24/2023
 * <br/>
 * Time: 6:06 PM
 * <br/>
 * Package: org.khasanof.basicValues.temporalAnnotation
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TemporalExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
        Date classni hibernate default TIMESTAMP typega o'zgaritib saqlaydi.
        Ushbu Date classni TIME yoki DATE typega o'zgartirmoqchi bo'lsak.
        @Temporal Annotatsiyasidan foydalanishimiz kerak.
     */
    // mapped as TIMESTAMP by default
    private Date dateAsTimestamp;

    // explicitly mapped as DATE
    @Temporal(TemporalType.DATE)
    private Date dateAsDate;

    // explicitly mapped as TIME
//    @Temporal(TemporalType.TIME)
    private Date dateAsTime;

    public TemporalExample(Date dateAsTimestamp, Date dateAsDate, Date dateAsTime) {
        this.dateAsTimestamp = dateAsTimestamp;
        this.dateAsDate = dateAsDate;
        this.dateAsTime = dateAsTime;
    }
}
