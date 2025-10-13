//
//  LandButtonNext.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ButtonNext: View {
    var condition: () -> Void

    var body: some View {
        Button(action: {
            condition()
        }) {
            Spacer()
            Text(IosStringResources(id:SharedRes.strings().next_page_button,args:[]))
                .fontWeight(.bold)
                .font(.custom(.h3Large))
                .foregroundColor(Color.buttonContent)
                .padding()
            Spacer()
        }.frame( height: 80).background(Color.buttonBackground).cornerRadius(50).shadow(color: .black.opacity(0.25), radius: 2, x: 0, y: 4).padding()
    }
}

#Preview {
    ButtonNext(condition: {})
}
