//
//  ProfilSlider.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ProfilSlider: View {
    @State private var selectedChip: String = "*"
    
    let chips = ["*", "Post", "Event", "Circuit"]

    var body: some View {
        HStack(spacing: 0) {
            ForEach(chips, id: \.self) { chip in
                ProfilChipSection(text: chip, isSelected: selectedChip == chip) {
                    selectedChip = chip
                }
            }
        }
        .padding(10)
        .background(Color.white)
        .overlay(
            RoundedRectangle(cornerRadius: 20)
                .stroke(Color.gray, lineWidth: 1)
        )
        .cornerRadius(20)
    }
}
