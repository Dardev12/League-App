//
//  ProfilChipSection.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ProfilChipSection: View {
    var text: String
    var isSelected: Bool
    var onSelected: () -> Void

    var body: some View {
        Text(text)
            .foregroundColor(isSelected ? .white : Color(hex: "#4EA7EE"))
            .padding(8)
            .frame(width: 80)
            .background(
                (isSelected ? Color(hex: "#4EA7EE") : Color.white)
                    .cornerRadius(20)
            )
            .onTapGesture {
                onSelected()
            }
    }
}
