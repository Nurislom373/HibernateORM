package org.khasanof.domainModel.embeddableValues.componentEmbedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Ko'pincha embeddable classlar bir nechta asosiy typelar guruhini bir nechta entitylarga
 * map qilib qayta ishlatilsh uchun ishlatiladi.
 * <br/>
 * Author: Nurislom
 * <br/>
 * Date: 1/25/2023
 * <br/>
 * Time: 9:56 PM
 * <br/>
 * Package: org.khasanof.embeddableValues.componentEmbedded
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Publisher {

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_country")
    private String country;
}
