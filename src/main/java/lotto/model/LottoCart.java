package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCart {
    private final List<Lotto> autoLottos;
    private final List<Lotto> manualLottos;
    private final PurchaseCount purchaseCount;

    public LottoCart(PurchaseCount purchaseCount) {
        this.autoLottos = new ArrayList<>();
        this.manualLottos = new ArrayList<>();
        this.purchaseCount = purchaseCount;
    }

    public void addManualLotto(List<String> inputs) {
        this.manualLottos.add(Lotto.from(inputs));
    }

    public void addAutoLottos() {
        while (!purchaseCount.isAuto(autoLottos.size())) {
            this.autoLottos.add(Lotto.ofRandom());
        }
    }

    public boolean isManualAvailable() {
        return !purchaseCount.isManual(manualLottos.size());
    }

    public Lottos getLottos() {
        List<Lotto> lottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public PurchaseCount getPurchaseCount() {
        return this.purchaseCount;
    }
}
